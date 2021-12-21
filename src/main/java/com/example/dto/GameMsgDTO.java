package com.example.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: tt
 * @Date: 2021/12/19 16:50
 */


//此类用于game的详细信息传输，前端中的game详细页面将使用此类中信息
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GameMsgDTO", description="game详细信息传输")
public class GameMsgDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "开发者")
    private String creater;

    @ApiModelProperty(value = "发行商")
    private String publisher;

    @ApiModelProperty(value = "游戏名字")
    private String name;

    @ApiModelProperty(value = "正常价格")
    private Double price;

    @ApiModelProperty(value = "打折后价格")
    private Double discount;

    @ApiModelProperty(value = "游戏简介")
    private String gameintroduction;

    @ApiModelProperty(value = "游戏详细介绍")
    private String gameabout;

    @ApiModelProperty(value = "系统配置要求")
    private String systemcfg;

    @ApiModelProperty(value = "发行时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime issueddate;

    @ApiModelProperty(value = "状态，0为未上架，1为已上架，2为已下架")
    private Integer stat;

    @ApiModelProperty(value = "游戏缩略图片")
    private String capsuleimage;

    @ApiModelProperty(value = "游戏大图列表")
    private List<String> images;
}
