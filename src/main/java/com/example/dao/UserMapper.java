package com.example.dao;


import com.example.dto.UserDetailDTO;
import com.example.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    void addUser(User user);

    //通过用户名查找user
    User findByUsername(String username);

    //通过用户id查询用户
    User findById(Integer userid);

    //修改个人详细信息
    void updateUserDetail(@Param("userDetail")UserDetailDTO userDetail,@Param("userid")Integer userid);

    void updateUserGameNum(int count);
}
