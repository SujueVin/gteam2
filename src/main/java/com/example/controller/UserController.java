package com.example.controller;


import com.example.po.User;
import com.example.pojo.UUser;
import com.example.service.impl.UserServiceImpl;
import com.example.util.CommonUtils;
import com.example.util.Result;
import com.example.util.ResultCode;
import com.example.util.mail.MailUtils;
import io.swagger.annotations.ApiOperation;
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
    //不需要返回整个user对象，只返回非隐私的数据
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
