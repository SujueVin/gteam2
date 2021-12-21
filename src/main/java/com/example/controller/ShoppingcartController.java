package com.example.controller;


import com.example.dto.CartGameDTO;
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
        List<CartGameDTO> cartList = shoppingcartService.findCartByid(userid);
        return Result.success(cartList);
    }

    //进行添加购物车操作，用于加入购物车
    //需要参数，用户id，cart列表类
    @PostMapping("")
    @ApiOperation(value = "添加购物车操作")
    public Result addCartGame(CartGameDTO cartGame) throws InvalidJwtException, MalformedClaimException {
        // 从 request header 中获取当前 token
        String accessToken = HttpContextUtil.getHttpServletRequest().getHeader(TokenConstant.ACCESS_TOKEN_NAME);
        //检验accesstoken是否过期,是否符合格式，不符合要求或者过期的话util类将会自动抛出异常
        int userid=Integer.parseInt(TokenUtil.getJwtClaims(accessToken, TokenConstant.tokenType.ACCESS_TOKEN).getAudience().get(0));

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

        //查询数据库,获取为token中对应userid的信息
        //这里需要使用service层查询数据库内对象，然后返回
        List<CartGameDTO> cartList = shoppingcartService.findCartByid(userid);
        int count = 0;
        for (CartGameDTO game:
                cartList) {
            Long id = game.getGameid();
            owngamesService.addGame(id,userid);
            gameService.updateGameSale(id);
            count++;
        }
        userService.updateUserGameNum(count);
        //直接删除
        shoppingcartService.deleteAllGames(userid);
        return Result.success();
    }

    @GetMapping("checkGame/{gameid}")
    @ApiOperation(value = "判断游戏是否被购买，或在购物车内")
    public Result checkGame(@PathVariable Integer gameid) throws InvalidJwtException, MalformedClaimException {
        // 从 request header 中获取当前 token
        String accessToken = HttpContextUtil.getHttpServletRequest().getHeader(TokenConstant.ACCESS_TOKEN_NAME);
        //检验accesstoken是否过期,是否符合格式，不符合要求或者过期的话util类将会自动抛出异常
        int userid=Integer.parseInt(TokenUtil.getJwtClaims(accessToken, TokenConstant.tokenType.ACCESS_TOKEN).getAudience().get(0));

        if(owngamesService.findOwnGamesById(gameid) != null){
            return Result.error(ResultCode.HAS_EXISTED_IN_OWNGAMES);
        }
        if(shoppingcartService.findCartByid(gameid) != null){
            return Result.error(ResultCode.HAS_EXISTED_IN_CART);
        }
        return Result.success();
    }
}
