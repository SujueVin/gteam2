package com.example.service.impl;

import com.example.dao.UserMapper;
import com.example.dto.UserDetailDTO;
import com.example.dto.UserDetailShowDTO;
import com.example.dto.UserMsgDTO;
import com.example.mongo.dao.UserDao;
import com.example.po.User;
import com.example.pojo.UUser;
import com.example.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;



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
        if(userMapper.findByUsername(username) != null)
            return true;
        return false;
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    //此函数用于用id找到用户信息
    @Override
    public User findUserByUserid(Integer userid) {
        User user=userMapper.findById(userid);
        return user;
    }

    //此函数用于生成展示个人信息的UsermsgDTO
    @Override
    public UserMsgDTO findUserMsg(String username) {
        User user=userMapper.findByUsername(username);
        UserMsgDTO userMsg =new UserMsgDTO();
        BeanUtils.copyProperties(user,userMsg);
        return userMsg;
    }

    //此函数用于生成展示可修改个人信息的UserDetailDTO
    @Override
    public UserDetailShowDTO findMyDetail(Integer userid) {
        User user=findUserByUserid(userid);
        UserDetailShowDTO userDetail =new UserDetailShowDTO();
        BeanUtils.copyProperties(user,userDetail);
        return userDetail;
    }

    //此函数用于修改个人信息传入数据为userDetail和userid
    @Override
    public void updateUserDetail(UserDetailDTO userDetail, Integer userid) {
       userMapper.updateUserDetail(userDetail,userid);
    }

    @Override
    public void updateUserGameNum(int count) {
        userMapper.updateUserGameNum(count);
    }


}
