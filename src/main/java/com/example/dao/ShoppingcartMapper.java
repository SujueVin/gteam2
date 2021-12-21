package com.example.dao;

import com.example.dto.CartGameDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author su_jue
 * @since 2021-12-19
 */
public interface ShoppingcartMapper {

    void deleteAllGames(Integer userid);

    void deleteGame(@Param("gameid")Integer gameId, @Param("userid") Integer userid);

    void addGame(@Param("cartGame")CartGameDTO cartGame, @Param("userid") Integer userid);

    List<CartGameDTO> findCartById(Integer userid);
}
