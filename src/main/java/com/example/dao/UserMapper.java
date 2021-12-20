package com.example.dao;


import com.example.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author su_jue
 * @since 2021-12-13
 */

@Repository("userMapper")
@Mapper
public interface UserMapper {

    public void addUser(User user);
    //通过用户名查找user
    User findByUsername();
}
