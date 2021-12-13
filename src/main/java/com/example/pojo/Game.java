package com.example.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 游戏表
 * </p>
 *
 * @author su_jue
 * @since 2021-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Game对象", description="游戏表")
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "开发者")
    private String creater;

    @ApiModelProperty(value = "游戏名字")
    private String name;

    @ApiModelProperty(value = "游戏描述")
    private String desc;

    @ApiModelProperty(value = "系统配置要求")
    private String systemcfg;

    @ApiModelProperty(value = "正常价格")
    private Double price;

    @ApiModelProperty(value = "打折后价格")
    private Double discount;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime ctime;

    @ApiModelProperty(value = "上架时间")
    private LocalDateTime utime;

    @ApiModelProperty(value = "状态，0为未上架，1为已上架，2为已下架")
    private Integer stat;


}
