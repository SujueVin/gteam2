package com.example.service;


import com.example.po.Owngames;

import java.util.List;

/**
 * <p>
 * 用户拥有游戏表 服务类
 * </p>
 *
 * @author su_jue
 * @since 2021-12-19
 */
public interface IOwngamesService {

    void addGame(Long gameid, int userid);

    List<Owngames> findOwnGamesById(int userid);

    Owngames findOwnGameById(int userid, Long gameid);
}
