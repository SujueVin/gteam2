package com.example.controller;


import com.example.dto.CartGameDTO;
import com.example.po.Owngames;
import com.example.service.IGameService;
import com.example.service.IOwngamesService;
import com.example.service.IShoppingcartService;
import com.example.service.IUserService;
import com.example.util.HttpContextUtil;
import com.example.util.Result.Result;
import com.example.util.Result.ResultCode;
import com.example.util.token.TokenConstant;
import com.example.util.token.TokenUtil;
import io.swagger.annotations.ApiOperation;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author su_jue
 * @since 2021-12-19
 */
@RestController
@RequestMapping("/shoppingcart")
public class ShoppingcartController {

    @Autowired
    private IShoppingcartService shoppingcartService;
    @Autowired
    private IOwngamesService owngamesService;
    @Autowired
    private IGameService gameService;
    @Autowired
    private IUserService userService;
    //获得购物车信息
    @GetMapping("")
    @ApiOperation(value = "获取购物车信息")
    public Result showCart() throws InvalidJwtException, MalformedClaimException {
        // 从 request header 中获取当前 token
        String accessToken = HttpContextUtil.getHttpServletRequest().getHeader(TokenConstant.ACCESS_TOKEN_NAME);
        //检验accesstoken是否过期,是否符合格式，不符合要求或者过期的话util类将会自动抛出异常
        int userid=Integer.parseInt(TokenUtil.getJwtClaims(accessToken, TokenConstant.tokenType.ACCESS_TOKEN).getAudience().get(0));
        //查询数据库,获取为token中对应userid的信息
        //这里需要使用service层查询数据库内对象，然后返回
        List<CartGameDTO> cartList = shoppingcartService.findCartById(userid);
        return Result.success(cartList);
    }

    //进行添加购物车操作，用于加入购物车，注意检验是否重复
    //需要参数，用户id，cart列表类
    @PostMapping("")
    @ApiOperation(value = "添加购物车操作")
    public Result addCartGame(CartGameDTO cartGame) throws InvalidJwtException, MalformedClaimException {
        // 从 request header 中获取当前 token
        String accessToken = HttpContextUtil.getHttpServletRequest().getHeader(TokenConstant.ACCESS_TOKEN_NAME);
        //检验accesstoken是否过期,是否符合格式，不符合要求或者过期的话util类将会自动抛出异常
        int userid=Integer.parseInt(TokenUtil.getJwtClaims(accessToken, TokenConstant.tokenType.ACCESS_TOKEN).getAudience().get(0));

        //加入前查看是否已经在购物车内
        //如果游戏已经在购物车中，说明需要显示已经在购物车中，不能操作,同时返回重复游戏数据
        Object gameRepeat=shoppingcartService.findCartGameById(userid,cartGame.getGameid());
        if(gameRepeat!= null){
            return Result.error(ResultCode.HAS_EXISTED_IN_CART,gameRepeat);
        }

        //直接加入
        shoppingcartService.addgame(cartGame,userid);
        return Result.success();
    }

    //进行删除操作，用于删除cart中某个游戏
    //需要参数，用户id，cart列表中某个游戏id
    @DeleteMapping("")
    @ApiOperation(value = "删除购物车中某个游戏")
    public Result deleteGame(Integer gameid) throws InvalidJwtException, MalformedClaimException {
        // 从 request header 中获取当前 token
        String accessToken = HttpContextUtil.getHttpServletRequest().getHeader(TokenConstant.ACCESS_TOKEN_NAME);
        //检验accesstoken是否过期,是否符合格式，不符合要求或者过期的话util类将会自动抛出异常
        int userid=Integer.parseInt(TokenUtil.getJwtClaims(accessToken, TokenConstant.tokenType.ACCESS_TOKEN).getAudience().get(0));

        //直接删除
        shoppingcartService.deletegame(gameid,userid);
        return Result.success();
    }

    //进行全体删除操作，用于删除cart中全部游戏
    //需要参数，用户id，
    @DeleteMapping("/all")
    @ApiOperation(value = "清空购物车")
    public Result deleteAllGames() throws InvalidJwtException, MalformedClaimException {
        // 从 request header 中获取当前 token
        String accessToken = HttpContextUtil.getHttpServletRequest().getHeader(TokenConstant.ACCESS_TOKEN_NAME);
        //检验accesstoken是否过期,是否符合格式，不符合要求或者过期的话util类将会自动抛出异常
        int userid=Integer.parseInt(TokenUtil.getJwtClaims(accessToken, TokenConstant.tokenType.ACCESS_TOKEN).getAudience().get(0));

        //直接删除
        shoppingcartService.deleteAllGames(userid);
        return Result.success();
    }

    @GetMapping("/confirmation")
    @ApiOperation(value = "购物车确认购买")
    public Result confirmation() throws InvalidJwtException, MalformedClaimException {
        // 从 request header 中获取当前 token
        String accessToken = HttpContextUtil.getHttpServletRequest().getHeader(TokenConstant.ACCESS_TOKEN_NAME);
        //检验accesstoken是否过期,是否符合格式，不符合要求或者过期的话util类将会自动抛出异常
        int userid=Integer.parseInt(TokenUtil.getJwtClaims(accessToken, TokenConstant.tokenType.ACCESS_TOKEN).getAudience().get(0));

        //这里需要使用service层查询数据库内购物车表单对象，然后返回，依照购物车表单进行一起加入
        List<CartGameDTO> cartList = shoppingcartService.findCartById(userid);
        //如果游戏已经存在库存中，说明需要显示已经在库存中，不能操作，同时返回游戏数据
        for (CartGameDTO game:
                cartList) {
            Object gameRepeat=owngamesService.findOwnGameById(userid,game.getGameid());
            if(gameRepeat!= null){
                return Result.error(ResultCode.HAS_EXISTED_IN_OWNGAMES,gameRepeat);
            }
        }
       //否则，正常加入到游戏库存中
        int count = 0;
        for (CartGameDTO game:
                cartList) {
            Long id = game.getGameid();
            owngamesService.addGame(id,userid);
            gameService.updateGameSale(id);
            count++;
        }
        //更新客户持有的游戏数目
        userService.updateUserGameNum(count);
        //直接删除购物车表单项
        shoppingcartService.deleteAllGames(userid);
        return Result.success();
    }

    @GetMapping("checkGame/{gameid}")
    @ApiOperation(value = "判断游戏是否被购买，或在购物车内")
    public Result checkGame(@PathVariable Long gameid) throws InvalidJwtException, MalformedClaimException {
        //登录才能进行这个接口的使用

        // 从 request header 中获取当前 token
        String accessToken = HttpContextUtil.getHttpServletRequest().getHeader(TokenConstant.ACCESS_TOKEN_NAME);
        //检验accesstoken是否过期,是否符合格式，不符合要求或者过期的话util类将会自动抛出异常
        int userid=Integer.parseInt(TokenUtil.getJwtClaims(accessToken, TokenConstant.tokenType.ACCESS_TOKEN).getAudience().get(0));

        //如果游戏已经存在库存中，说明需要显示已经在库存中，不能跳转，同时返回游戏数据
        Object game=owngamesService.findOwnGameById(userid,gameid);
        if(game!= null){
            return Result.error(ResultCode.HAS_EXISTED_IN_OWNGAMES,game);
        }

        //如果游戏已经在购物车中，说明需要显示已经在购物车中，不能跳转,同时返回游戏数据
        game=shoppingcartService.findCartGameById(userid,gameid);
        if(game!= null){
            return Result.error(ResultCode.HAS_EXISTED_IN_CART,game);
        }

        return Result.success("可加入购物车");
    }
}
