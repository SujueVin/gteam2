package com.example.controller;


import com.example.pojo.UserToken;
import com.example.service.impl.TokenServiceImpl;
import com.example.util.HttpContextUtil;
import com.example.util.Result.Result;
import com.example.util.Result.ResultCode;
import com.example.util.token.TokenConstant;
import com.example.util.token.TokenUtil;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private TokenServiceImpl tokenService;

    //获取accesstoken接口
    //参数需要：一个refreshtoken,一个头部的userid
    @PostMapping("")
    public Result token() throws InvalidJwtException, JoseException, MalformedClaimException {

        //检验refreshtoken是否过期，是的话util类将会自动处理数据库，抛出异常
        String refreshToken = HttpContextUtil.getHttpServletRequest().getHeader(TokenConstant.REFRESH_TOKEN_NAME);
        String userid = HttpContextUtil.getHttpServletRequest().getHeader("userid");

        //获取Jwtclaims,获取其中的userid,和传过来的username进行对比
        JwtClaims Jwtclaims=TokenUtil.getJwtClaims(refreshToken, TokenConstant.tokenType.REFRESH_TOKEN);
        String useridInToken=Jwtclaims.getAudience().get(0);


        if (!refreshToken.equals(tokenService.findToken(useridInToken).getToken())){
            //如果传过来的token在表中对应上不是一样的。返回token重复，需要重新登录
            tokenService.delToken(useridInToken);
            return Result.error(ResultCode.NEED_LOGIN);
        }

        //完成检验，进行生成新的
        String accessToken =TokenUtil.accessTokenSign(useridInToken);
        String newRefreshToken =TokenUtil.refreshTokenSign(useridInToken);
        String[] tokens = {"",""};
        tokens[0] = accessToken;
        tokens[1] = newRefreshToken;

        //更新db中的userid项对应的token
        UserToken userToken=new UserToken();
        userToken.setUserid(userid);
        userToken.setToken(newRefreshToken);

        //更新
        tokenService.changeToken(userToken);
        //完成，返回tokens
        return Result.success(tokens);
    }

}
