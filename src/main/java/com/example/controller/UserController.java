package com.example.controller;


import com.example.pojo.User;
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
    //注册用户
 /*   @RequestMapping(value="/getUserById/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultModel insertBasicUser(BasicUser basicUser) {
        int row = basicUserService.insert(basicUser);
        if(row > 0) {
            return new ResultModel(201, row, "新增成功");
        }
        return new ResultModel(200, row, "新增失败");
    }*/

    //查询用户
    @RequestMapping(value = "/getUserById/{username}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable("username") int userid){
        //System.out.println("yesyes");
        User user = new User();
        user.setId(1);
        user.setUsername("666");
        //这里需要使用service层查询数据库内对象，然后返回
        return user;//没有查到，返回空对象user对应的json数据
    }

    //用户更新数据
    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateById(@PathVariable("id")Integer id, String userName) {
//        BasicUser basicUser = new BasicUser();
//        basicUser.setId(id);
//        basicUser.setRealname(realname);
//        int row = basicUserService.updateById(basicUser);
//        if(row > 0) {
//            return new ResultModel(201, row, "更新成功");
//        }
        System.out.println("更新用户数据成功id="+id+userName);
        return "200";
    }
    //删除用户
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteById(@PathVariable("id")Integer id) {
        //int row = basicUserService.deleteById(id);
//        if(row > 0) {
//            return "200";
//        }
        System.out.println("删除id"+id);
        return "404";
    }
}
