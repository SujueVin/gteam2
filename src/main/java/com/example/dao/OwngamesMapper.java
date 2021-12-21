package com.example.dao;


import com.example.po.Owngames;

import java.util.List;

/**
 * <p>
 * 用户拥有游戏表 Mapper 接口
 * </p>
 *
 * @author su_jue
 * @since 2021-12-19
 */
public interface OwngamesMapper{


    void addGame(Owngames game);

    List<Owngames> findeOwnGamesById(int userid);
}
