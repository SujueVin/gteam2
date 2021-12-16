package com.example.controller;


import com.example.po.Game;
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

    //查询用户
    @GetMapping("/getUserById/{userid}")
    public Result getUserById(@PathVariable("userid") int userid){
        User user = new User();
        user.setId(1);
        user.setUsername("666");
        //这里需要使用service层查询数据库内对象，然后返回
        if (userid==2){//能够查到，进行返回
            return Result.success(user);
        }
        return Result.fail(ResultCode.PARAM_IS_INVALID);//没有查到，返回空对象user对应的json数据
    }

    //用户更新数据
    @PutMapping("/{id}")
    public Result updateById(@PathVariable("id")Integer id, String userName) {

        Game game =new Game();
        game.setId(2);
        game.setDesc("a123");

        return Result.success(game);
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
            return Result.fail(ResultCode.PARAM_IS_INVALID);
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
            return Result.fail(ResultCode.PARAM_IS_INVALID);
        }
        return Result.success();
    }
}
