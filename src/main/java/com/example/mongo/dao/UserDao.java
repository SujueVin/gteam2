package com.example.mongo.dao;


import com.example.pojo.UUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;


/**
 * @ClassName UserDao
 * @Description mongo的dao层
 * @date 2021/12/16 14:46
 * @Version 1.0
 * @Author HJW
 */

public interface UserDao extends MongoRepository<UUser, String> {
}
