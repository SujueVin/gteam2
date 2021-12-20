package com.example.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: tt
 * @Date: 2021/12/18 12:31
 */

//此类用于game的简单信息传输，前端中的game列表将使用此类中信息
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GameListDTO", description="game简单信息传输")
public class GameListDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "游戏名字")
    private String name;

    @ApiModelProperty(value = "正常价格")
    private Double price;

    @ApiModelProperty(value = "打折后价格")
    private Double discount;

    @ApiModelProperty(value = "上架时间")
    private LocalDateTime issueddate;

    @ApiModelProperty(value = "游戏标签名字")
    private String tagname;

    @ApiModelProperty(value = "游戏缩略图片")
    private String capsuleimage;


}
