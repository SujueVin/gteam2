package com.example.mongo.dao;


import com.example.pojo.UserToken;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TokenDao extends MongoRepository<UserToken,String> {
}
