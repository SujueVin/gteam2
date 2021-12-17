package com.example.controller;


import com.example.util.HttpContextUtil;
import com.example.util.Result.Result;
import com.example.util.Result.ResultCode;
import com.example.util.token.TokenConstant;
import com.example.util.token.TokenUtil;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.lang.JoseException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/token")
public class TokenController {

    //获取accesstoken接口
    //参数需要：一个refreshtoken
    @PostMapping("")
    public Result token() throws InvalidJwtException, MalformedClaimException, JoseException {

        //检验refreshtoken是否过期，是的话util类将会自动处理数据库，抛出异常
        String refreshToken = HttpContextUtil.getHttpServletRequest().getHeader(TokenConstant.REFRESH_TOKEN_NAME);
        TokenUtil.checkJwt(refreshToken, TokenConstant.tokenType.REFRESH_TOKEN);

        //同时如果没有过期，和db中对应uid项的token对比，如果不是一个，返回没有权限，需要重新登录
        JwtClaims Jwtclaims=TokenUtil.getJwtClaims(refreshToken, TokenConstant.tokenType.REFRESH_TOKEN);
        String uid=Jwtclaims.getAudience().get(0);
        //这里使用mongodb获取uid
        if ("11".equals(uid)){
            //如果不是一个，将db表中对应uid项删除，返回没有权限，需要重新登录
            return Result.error(ResultCode.NEED_LOGIN);
        }
        //如果没有过期，且和uid中token一致，使用jwt生成refreshtoken和accesstoken

        //需要解析token，之后获取uid，再获取token
        String accessToken =TokenUtil.accessTokenSign(uid);
        String newRefreshToken =TokenUtil.refreshTokenSign(uid);
        String[] tokens = {"",""};
        tokens[0] = accessToken;
        tokens[1] = newRefreshToken;

        //更新db中的uid项对应的token

        //完成，返回tokens
        return Result.success(tokens);
    }

}
