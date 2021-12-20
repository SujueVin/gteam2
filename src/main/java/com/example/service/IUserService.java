package com.example.service;



import com.example.po.User;
import com.example.pojo.UUser;

import java.util.UUID;

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
}
