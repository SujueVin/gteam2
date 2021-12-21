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

    //获得购物车信息
    @Override
    public List<CartGameDTO> findCartByid(int userid) {
        return shoppingcartMapper.findCartById(userid);
    }

    //向购物车中添加游戏,注意，有可能购物车内已经有对应的物品了
    @Override
    public void addgame(CartGameDTO cartGame, int userid) {
        shoppingcartMapper.addGame(cartGame,userid);
    }

    @Override
    public void deletegame(Integer gameid, int userid) {
        shoppingcartMapper.deleteGame(gameid,userid);
    }

    @Override
    public void deleteAllGames(int userid) {
        shoppingcartMapper.deleteAllGames(userid);
    }
}
