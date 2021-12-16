package com.example.controller;


import com.example.pojo.User;
import com.example.util.Result;
import com.example.util.ResultCode;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    //登录获取token
    //参数需要：password,username，通过post加密传输保证传输信息安全
    @PostMapping("")
    public Result login(String userName,String password) {
        //从数据库中获取数据，新建user对象进行接收
        User dataUser=new User();
        dataUser.setPassword("111111");
        /*
        这里是数据库操作
         */
        //这里进行验证密码操作，对得到的密码加盐md5处理，之后验证是否相等
        if (!dataUser.getPassword().equals(password)){
            //不相等，返回错误码参数不正确
            return Result.error(ResultCode.PARAM_IS_INVALID);
        }
        //验证成功，进行token的产生，使用token工具类
        String accessToken ="aa";
        String refreshToken ="bb";
        String[] tokens = {"",""};
        tokens[0] =accessToken;
        tokens[1] =refreshToken;
        //产生两个token
        //返回tokens
        return Result.success(tokens);
    }


}
