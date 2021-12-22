package com.example.service;


import com.example.dto.CartGameDTO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author su_jue
 * @since 2021-12-19
 */
public interface IShoppingcartService{


    //通过userid找到玩家购物车表
    List<CartGameDTO> findCartById(int userid);

    //通过userid和gameid找到玩家购物车中是否有这个.
    CartGameDTO findCartGameById(int userid, Long gameid);

    void addgame(CartGameDTO cartList, int userid);

    void deletegame(Integer gameid, int userid);

    void deleteAllGames(int userid);
}
