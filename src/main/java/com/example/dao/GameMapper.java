package com.example.dao;


import com.example.dto.GameListDTO;
import com.example.dto.GameMsgDTO;
import com.example.dto.GameRecommendDTO;
import com.example.dto.SpecialDTO;
import com.example.po.Game;
import com.example.po.Owngames;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 游戏表 Mapper 接口
 * </p>
 *
 * @author su_jue
 * @since 2021-12-13
 */

@Repository("gameMapper")
@Mapper
public interface GameMapper  {
    //获取首页推荐游戏
    List<GameRecommendDTO> getRecommendList();
    //根据游戏id获取图片链接
    List<String> findImgByGameID(Integer id);

    List<SpecialDTO> getSpecialGame();

    List<GameListDTO> getHotGameList(Integer num);

    List<String> findTagByGameID(Integer id);

    GameMsgDTO getGameDetail(Integer gameID);

    List<GameListDTO> getGameByName(String gameName);


    Owngames findGameById(Long gameid);

    void updateGameSale(Long id);
}
