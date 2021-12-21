package com.example.service;


import com.example.dto.GameListDTO;
import com.example.dto.GameMsgDTO;
import com.example.dto.GameRecommendDTO;
import com.example.dto.SpecialDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>
 * 游戏表 服务类
 * </p>
 *
 * @author su_jue
 * @since 2021-12-13
 */
public interface IGameService  {

    List<GameRecommendDTO> getRecommendList();


    List<SpecialDTO> getSpecialGame();

    List<GameListDTO> getHotGameList(Integer num);

    GameMsgDTO getGameDetail(Integer gameID);


    PageInfo getGameByName(String gameName, Integer pageNum);
}
