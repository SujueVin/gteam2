package com.example.controller;


import com.example.pojo.Game;
import com.example.pojo.User;
import com.example.util.Result;
import com.example.util.ResultCode;
import org.springframework.web.bind.annotation.*;

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

}
