package com.example.service;

import com.example.pojo.UserToken;

/**
 *
 * @Date: 2021/12/20 14:23
 */
public interface ITokenService {

    void addTokenToMongo(UserToken usertoken);

    UserToken findToken(String userid);

    void delToken(String userid);

}
