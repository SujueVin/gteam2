package com.example.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author: tt
 * @Date: 2021/12/19 15:13
 */

//此类用于传输首页中的推荐滑动框
//前端将使用此接口获得每日的GameRecommendDTO类数组
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GameRecommendDTO", description="推荐游戏信息")
public class GameRecommendDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "推荐游戏名字")
    private String gamename;

    @ApiModelProperty(value = "推荐游戏价格")
    private Double price;

    @ApiModelProperty(value = "推荐游戏打折后价格")
    private Double discount;

    @ApiModelProperty(value = "推荐游戏大图列表")
    private List<String> images;

}
