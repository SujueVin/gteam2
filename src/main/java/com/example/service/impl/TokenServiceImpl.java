package com.example.service.impl;

import com.example.mongo.dao.TokenDao;
import com.example.pojo.UserToken;
import com.example.service.ITokenService;
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
public class TokenServiceImpl implements ITokenService {

    @Autowired
    private TokenDao tokenDao;

    @Override
    public void addTokenToMongo(UserToken usertoken) {
        tokenDao.save(usertoken);
    }

    @Override
    public UserToken findToken(String userid) {
        Optional<UserToken> T = tokenDao.findById(userid);
        if(T.isPresent()){
            //如果存在，返回
            UserToken userToken = T.get();
            return userToken;
        }
        //如果不存在，返回空
        return null;
    }

    @Override
    public void delToken(String userid) {
        tokenDao.deleteById(userid);
    }

    public void changeToken(UserToken userToken){
        Optional<UserToken> optional = tokenDao.findById(userToken.getUserid());
        if(optional.isPresent()){//如果存在，
            System.out.println(userToken.getToken());
            UserToken userTokenInDB = optional.get();
            userTokenInDB.setToken(userToken.getToken());
            userTokenInDB.setUserid(userToken.getUserid());
            tokenDao.save(userTokenInDB);
        }else{
            addTokenToMongo(userToken);

        }

    }
}
