package com.example.controller;


import com.example.po.User;
import com.example.pojo.RegisterParam;
import com.example.pojo.UUser;
import com.example.service.impl.UserServiceImpl;
import com.example.util.CommonUtils;
import com.example.util.Result.Result;
import com.example.util.Result.ResultCode;
import com.example.util.mail.MailUtils;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

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
    @Autowired
    private DefaultKaptcha defaultKaptcha;

    //查询用户详细信息，登录后可以查询自己的信息
    //不需要返回整个user对象，只返回非隐私的数据
    @GetMapping("/detail")
    public Result getUserById(int userid){
        User user = new User();
        user.setUsername("666");
        //这里需要使用service层查询数据库内对象，然后返回
        if (userid==2){//能够查到，进行返回
            return Result.success(user);
        }
        return Result.error(ResultCode.PARAM_IS_INVALID);//没有查到，返回空对象user对应的json数据
    }

    //用户更新数据,只能更新自己的数据，接收user变量？
    //user变量好像失败了，为什么不能传入自定义数据？
    @PutMapping("/update")
    public Result updateById(User user) {
        //接收到数据之后，直接将值赋值给数据库
        //要求前端必须保证user类的完整性。
        //但是user类中有需要屏蔽的信息——比如password
        //salt保存在用户表内，但是用户更改数据的时候不需要更改
        //需要一个中介类，或者直接让他们传入各个参数
        System.out.println(user.getEmail());
        return Result.success(user);
    }

    /**
     * 注册
     * @return
     */
    @PostMapping("/register")
    @ApiOperation(value = "注册用户", tags = "提交表单注册用户")
    public Result register(@RequestBody RegisterParam registerParam){
        try {

            String email = registerParam.getEmail();
            userService.findUUser(registerParam.getCode());
            User user = new User();
            user.setUsername(registerParam.getUsername());
            user.setPassword(registerParam.getPassword());
            user.setEmail(email);
            user.setStat(1);
            user.setCtime(LocalDateTime.now());
            user.setNickname(email);
            userService.addUser(user);
            userService.delUUser(email);
        }catch (Exception e){
            return Result.error(ResultCode.PARAM_IS_INVALID);
        }
        return Result.success();
    }

    @GetMapping("/isRegister/{username}")
    @ApiOperation(value = "判断用户名是否被注册",tags = "判断用户名是否被注册")
    public Result checkRegister( @PathVariable String username){
        if(userService.findByUsername(username)){
            return Result.error(ResultCode.USERNAME_IS_INVALID);
        }
        return Result.success();
    }

    @GetMapping("/captcha/{email}")
    @ApiOperation(value = "邮箱验证码",tags = "发送邮箱验证码")
    public Result captcha(@PathVariable String email){
        String code = defaultKaptcha.createText();
        UUser uUser = new UUser();
        uUser.setCode(code);
        uUser.setEmail(email);
        uUser.setCreatedTime(new Date());
        try {
            userService.addUserToMongo(uUser);
            MailUtils sendMail = new MailUtils();
            sendMail.sendMail(email,code);
        }catch (Exception e){
            System.out.println(e);
            return Result.error(ResultCode.PARAM_IS_INVALID);
        }
        return Result.success();
    }
}
