package com.example.service.impl;

import com.example.dao.UserMapper;
import com.example.mongo.dao.UserDao;
import com.example.po.User;
import com.example.pojo.UUser;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author su_jue
 * @since 2021-12-13
 */
@Service
public class UserServiceImpl  implements IUserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUserToMongo(UUser user) {
        userDao.save(user);
    }

    @Override
    public UUser findUUser(String uuid) {
        Optional<UUser> U = userDao.findById(uuid);
        UUser uUser = U.get();
        return uUser;
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void delUUser(String email) {
        userDao.deleteById(email);
    }
    //通过用户名查找user
    @Override
    public boolean findByUsername(String username) {
        if(userMapper.findByUsername() != null)
            return true;
        return false;
    }


}
