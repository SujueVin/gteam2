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

    List<CartGameDTO> findCartByid(int userid);

    void addgame(CartGameDTO cartList, int userid);

    void deletegame(Integer gameid, int userid);

    void deleteAllGames(int userid);
}
