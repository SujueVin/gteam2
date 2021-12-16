package com.example.controller;


import com.example.pojo.User;
import com.example.util.Result;
import com.example.util.ResultCode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {

    //获取accesstoken接口
    //参数需要：一个refreshtoken
    @PostMapping("")
    public Result token(String refreshToken) {

        //检验refreshtoken是否过期
        //同时如果没有过期，和db中对应uid项的token对比，如果不是一个，返回没有权限，需要重新登录
        if (false){
            //如果过期或者不是一个，将db表中对应uid项删除，返回没有权限，需要重新登录
            return Result.error(ResultCode.NEED_LOGIN);
        }
        //如果没有过期，且和uid中token一致，使用jwt生成refreshtoken和accesstoken
        String accessToken ="aa";
        String newRefreshToken ="bb";
        String[] tokens = {"",""};
        tokens[0] =accessToken;
        tokens[1] =newRefreshToken;

        //更新db中的uid项对应的token

        //完成，返回tokens
        return Result.success(tokens);
    }

}
