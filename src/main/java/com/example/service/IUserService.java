package com.example.service;



import com.example.dto.UserDetailDTO;
import com.example.dto.UserDetailShowDTO;
import com.example.dto.UserMsgDTO;
import com.example.po.User;
import com.example.pojo.UUser;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author su_jue
 * @since 2021-12-13
 */
public interface IUserService  {
    void addUserToMongo(UUser uUser);
    UUser findUUser(String uuid);

    void addUser(User user);

    void delUUser(String email);

    boolean findByUsername(String username);

    User findUserByUsername(String username);

    //此函数用于用id找到用户数据
    User findUserByUserid(Integer userid);

    //此函数用于生成展示个人信息的UsermsgDTO
    UserMsgDTO findUserMsg(Integer userid);

    //此函数用于生成展示可修改个人信息的UserDetailDTO
    UserDetailShowDTO findMyDetail(Integer userid);

    //此函数用于更新用户个人空间数据
    void updateUserDetail(UserDetailDTO userDetail, Integer userid);

}
