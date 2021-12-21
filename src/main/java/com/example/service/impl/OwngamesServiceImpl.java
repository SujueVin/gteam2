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

    @Override
    public void addGame(Long gameId,int userId) {
        Owngames game = gameMapper.findGameById(gameId);
        game.setUserid(userId);
        owngamesMapper.addGame(game);
    }

    @Override
    public List<Owngames> findOwnGamesById(int userid) {
        return owngamesMapper.findeOwnGamesById(userid);
    }
}
