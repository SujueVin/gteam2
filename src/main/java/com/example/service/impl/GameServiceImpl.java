package com.example.service.impl;

import com.example.dao.GameMapper;
import com.example.dto.GameListDTO;
import com.example.dto.GameMsgDTO;
import com.example.dto.GameRecommendDTO;
import com.example.dto.SpecialDTO;
import com.example.service.IGameService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 游戏表 服务实现类
 * </p>
 *
 * @author su_jue
 * @since 2021-12-13
 */
@Service
public class GameServiceImpl  implements IGameService {

    @Autowired
    private GameMapper gameMapper;
    //获取首页推荐游戏
    @Override
    public List<GameRecommendDTO> getRecommendList() {
        List<GameRecommendDTO> recommendList = gameMapper.getRecommendList();
        for (GameRecommendDTO recommendDTO:recommendList) {
            recommendDTO.setImages(gameMapper.findImgByGameID(recommendDTO.getId()));
        }
        return recommendList;
    }

    @Override
    public List<SpecialDTO> getSpecialGame() {
        return gameMapper.getSpecialGame();
    }

    @Override
    public List<GameListDTO> getHotGameList(Integer num) {
        List<GameListDTO> gameListDTOS = gameMapper.getHotGameList(num*10);
        for (GameListDTO gameListDto :
                gameListDTOS) {
            gameListDto.setTagnames(gameMapper.findTagByGameID(gameListDto.getId()));
        }
        return gameListDTOS;
    }

    @Override
    public GameMsgDTO getGameDetail(Integer gameID) {
        return gameMapper.getGameDetail(gameID);
    }

    @Override
    public PageInfo getGameByName(String gameName, Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<GameListDTO> list = gameMapper.getGameByName(gameName);
        for (GameListDTO game:
             list) {
            game.setTagnames(gameMapper.findTagByGameID(game.getId()));
        }
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    //增加游戏销量，只能加一
    @Override
    public void updateGameSale(Long id) {
        gameMapper.updateGameSale(id);
    }
}
