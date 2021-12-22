package com.example.service.impl;

import com.example.dao.GameMapper;
import com.example.dao.OwngamesMapper;
import com.example.po.Owngames;
import com.example.service.IOwngamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户拥有游戏表 服务实现类
 * </p>
 *
 * @author su_jue
 * @since 2021-12-19
 */
@Service
public class OwngamesServiceImpl implements IOwngamesService {

    @Autowired
    private OwngamesMapper owngamesMapper;
    @Autowired
    private GameMapper gameMapper;


    //向游戏库存中添加游戏
    @Override
    public void addGame(Long gameId,int userId) {
        Owngames game = gameMapper.findGameById(gameId);
        game.setUserid(userId);
        owngamesMapper.addGame(game);
    }


    //通过userid获取玩家库存列表
    @Override
    public List<Owngames> findOwnGamesById(int userid) {
        return owngamesMapper.findOwnGamesById(userid);
    }

    //通过userid和gameid查询游戏信息
    @Override
    public Owngames findOwnGameById(int userid, Long gameid) {
        return owngamesMapper.findOwnGameById(userid,gameid);
    }
}
