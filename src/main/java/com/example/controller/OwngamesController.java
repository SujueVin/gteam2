package com.example.controller;


import com.example.po.Owngames;
import com.example.service.IOwngamesService;
import com.example.util.HttpContextUtil;
import com.example.util.Result.Result;
import com.example.util.token.TokenConstant;
import com.example.util.token.TokenUtil;
import io.swagger.annotations.ApiOperation;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户拥有游戏表 前端控制器
 * </p>
 *
 * @author su_jue
 * @since 2021-12-19
 */
@RestController
@RequestMapping("/owngames")
public class OwngamesController {

    @Autowired
    private IOwngamesService owngamesService;

    @GetMapping()
    @ApiOperation("获取自己的游戏库存列表")
    public Result getGame() throws InvalidJwtException, MalformedClaimException {
        // 从 request header 中获取当前 token
        String accessToken = HttpContextUtil.getHttpServletRequest().getHeader(TokenConstant.ACCESS_TOKEN_NAME);
        //检验accesstoken是否过期,是否符合格式，不符合要求或者过期的话util类将会自动抛出异常
        int userid=Integer.parseInt(TokenUtil.getJwtClaims(accessToken, TokenConstant.tokenType.ACCESS_TOKEN).getAudience().get(0));

        List<Owngames> list = owngamesService.findOwnGamesById(userid);
        return Result.success(list);
    }
}
