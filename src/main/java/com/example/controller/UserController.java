package com.example.controller;


import com.example.dto.UserMsgDTO;
import com.example.po.User;
import com.example.pojo.UUser;
import com.example.service.impl.UserServiceImpl;
import com.example.util.CommonUtils;
import com.example.util.Result.Result;
import com.example.util.Result.ResultCode;
import com.example.util.mail.MailUtils;
import com.example.util.token.TokenUtil;
import io.swagger.annotations.ApiOperation;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.lang.JoseException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author su_jue
 * @since 2021-12-13
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    //查询用户详细信息，登录后可以查询自己的信息
    //不需要返回整个user对象，只返回非隐私的数据，返回userDTO对象
    @GetMapping("/detail")
    public Result getUserById(int userid){
        User user = new User();
        user.setId(1);
        user.setUsername("666");
        //这里需要使用service层查询数据库内对象，然后返回
        if (userid==2){//能够查到，进行返回
            return Result.success(user);
        }
        return Result.error(ResultCode.PARAM_IS_INVALID);//没有查到，返回空对象user对应的json数据
    }

    //用户更新数据,只能更新自己的数据，接收userDTO对象
    @PutMapping("/update")
    public Result updateById(@RequestBody UserMsgDTO user) {
        //接收到数据之后,修改数据库内信息
        //直接调用server层进行数据的注入
        //userService.upUserMsg(user);
        return Result.success();
    }


    //登录获取token
    //参数需要：password,username，通过post加密传输保证传输信息安全
    @PostMapping("/login")
    public Result login(String userName,String password) throws JoseException {
        //从数据库中获取数据，使用username查询password
        //String dbUserPassword=userService.getpassword(userName);

        //这里进行验证密码操作，对得到的密码加盐md5处理，之后验证是否相等
//        if (!dbUserPassword.equals(password)){
//            //不相等，返回错误码参数不正确
//            return Result.error(ResultCode.PARAM_IS_INVALID);
//        }

        //验证成功，进行token的产生，使用token工具类
        String accessToken = TokenUtil.accessTokenSign(userName);
        String refreshToken =TokenUtil.refreshTokenSign(userName);
        String[] tokens = {"",""};
        tokens[0] =accessToken;
        tokens[1] =refreshToken;
        //产生两个token
        //返回tokens
        return Result.success(tokens);
    }


    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    @ApiOperation(value = "注册用户", tags = "提交表单注册用户")
    public Result register(@RequestBody User user){
        user.setStat(1);
        user.setCtime(LocalDateTime.now());
        user.setNickname(user.getEmail());
        UUser uUser = new UUser();
        uUser.setUser(user);
        uUser.setUuid(CommonUtils.getUUID());
        System.out.println(uUser.getUuid());
        try {
            userService.addUserToMongo(uUser);
            MailUtils.sendMail(user.getEmail(),uUser.getUuid());
        }catch (Exception e){
            return Result.error(ResultCode.PARAM_IS_INVALID);
        }
        return Result.success();
    }

    /**
     * 邮箱激活注册
     * @param code
     * @return
     */
    @GetMapping("checkRegister/{code}")
    @ApiOperation(value = "邮箱验证",tags = "点击按钮完成注册激活")
    public Result checkRegister(@PathVariable String code){
        System.out.println(code);
        UUser uUser = userService.findUUser(code);
        User user = uUser.getUser();
        user.setStat(0);
        try {
            userService.addUser(user);
            userService.delUUser(code);
        }catch (Exception e){
            return Result.error(ResultCode.PARAM_IS_INVALID);
        }
        return Result.success();
    }
}
