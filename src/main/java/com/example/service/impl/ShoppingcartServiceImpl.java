package com.example.service.impl;

import com.example.dao.ShoppingcartMapper;
import com.example.dto.CartGameDTO;
import com.example.service.IShoppingcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author su_jue
 * @since 2021-12-19
 */
@Service
public class ShoppingcartServiceImpl implements IShoppingcartService {

    @Autowired
    private ShoppingcartMapper shoppingcartMapper;

    //获得购物车信息列表，通过userid获取
    @Override
    public List<CartGameDTO> findCartById(int userid) {
        return shoppingcartMapper.findCartById(userid);
    }

    //通过userid和gameid获取购物车游戏
    @Override
    public CartGameDTO findCartGameById(int userid, Long gameid) {
        return shoppingcartMapper.findCartGameById(userid,gameid);
    }

    //向购物车中添加游戏,注意，有可能购物车内已经有对应的物品了
    @Override
    public void addgame(CartGameDTO cartGame, int userid) {
        shoppingcartMapper.addGame(cartGame,userid);
    }

    //删除购物车中某个游戏
    @Override
    public void deletegame(Integer gameid, int userid) {
        shoppingcartMapper.deleteGame(gameid,userid);
    }

    //删除购物车所有游戏
    @Override
    public void deleteAllGames(int userid) {
        shoppingcartMapper.deleteAllGames(userid);
    }
}
