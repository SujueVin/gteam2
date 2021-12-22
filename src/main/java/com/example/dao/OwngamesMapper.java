package com.example.dao;


import com.example.po.Owngames;
import org.apache.ibatis.annotations.Param;

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

    //查询游戏信息列表
    List<Owngames> findOwnGamesById(Integer userid);

    //查询单个游戏信息
    Owngames findOwnGameById(@Param("userid")int userid,@Param("gameid") Long gameid);
}
