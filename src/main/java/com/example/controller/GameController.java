package com.example.controller;


import com.example.dto.GameListDTO;
import com.example.dto.GameMsgDTO;
import com.example.dto.GameRecommendDTO;
import com.example.dto.SpecialDTO;
import com.example.service.IGameService;
import com.example.util.Result.Result;
import com.example.util.Result.ResultCode;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 游戏表 前端控制器
 * </p>
 *
 * @author su_jue
 * @since 2021-12-19
 */
@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private IGameService gameService;

    @GetMapping("recommend")
    @ApiOperation(value = "获取首页推荐游戏")
    public Result getRecommend(){
        List<GameRecommendDTO> gameRecommendDTOSList;
        try {
            gameRecommendDTOSList = gameService.getRecommendList();
            if(gameRecommendDTOSList == null){
                return Result.error(ResultCode.NOT_EXISTS);
            }
        }catch (Exception e){
            return Result.error(ResultCode.MYBATIS_EXCEPTION);
        }
        return Result.success(gameRecommendDTOSList);
    }

    @GetMapping("/special")
    @ApiOperation(value = "获取最优惠的游戏")
    public Result special(){
        List<SpecialDTO> specialDTOS;
        try{
            specialDTOS = gameService.getSpecialGame();
            if(specialDTOS == null)
                return Result.error(ResultCode.NOT_EXISTS);
        }catch (Exception e){
            return Result.error(ResultCode.MYBATIS_EXCEPTION);
        }
        return Result.success(specialDTOS);
    }

    @GetMapping("/sale/{num}")
    @ApiOperation(value = "热门商品和新品")
    public Result hotSale(@PathVariable Integer num){
        List<GameListDTO> gameListDTOS;
        try {
            gameListDTOS = gameService.getHotGameList(num);
        }catch (Exception e){
            return Result.error(ResultCode.MYBATIS_EXCEPTION);
        }
        return Result.success(gameListDTOS);
    }

    @GetMapping("/search/{gameName}/{pageNum}")
    @ApiOperation(value = "搜索游戏")
    public Result searchGame(@PathVariable String gameName, @PathVariable Integer pageNum){
        PageInfo gameListDTOList;
        try{
            gameListDTOList = gameService.getGameByName(gameName,pageNum);
            Result.error(ResultCode.NOT_EXISTS);
        }catch (Exception e){
            return Result.error(ResultCode.MYBATIS_EXCEPTION);
        }
        return Result.success(gameListDTOList);
    }

    @GetMapping("/detail/{gameID}")
    @ApiOperation(value = "获取游戏详情")
    public Result getGameDetail(@PathVariable Integer gameID){
        GameMsgDTO gameMsgDTO;
        try{
            gameMsgDTO = gameService.getGameDetail(gameID);
            if(gameMsgDTO == null)
                Result.error(ResultCode.NOT_EXISTS);
        }catch (Exception e){
            return Result.error(ResultCode.MYBATIS_EXCEPTION);
        }
        return Result.success(gameMsgDTO);
    }

}
