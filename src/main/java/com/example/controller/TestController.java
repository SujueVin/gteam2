package com.example.controller;

import com.example.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description 测试
 * @date 2021/12/15 21:10
 * @Version 1.0
 * @Author HJW
 */
@RestController
public class TestController {
    @Autowired
    private UserServiceImpl userService;



    @Autowired
    private MongoTemplate mongoTemplate;


}