package com.example.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author su_jue
 * @since 2021-12-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Shoppingcart对象", description="用于进行购物车信息传输")
public class Shoppingcart implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "购物车用户id")
    private Integer userid;

    @ApiModelProperty(value = "购物车游戏名")
    private String gamename;

    @ApiModelProperty(value = "购物车游戏id")
    private Long gameid;

    @ApiModelProperty(value = "游戏折扣价")
    private Double discount;

    @ApiModelProperty(value = "游戏价格")
    private Double price;

    @ApiModelProperty(value = "游戏缩咯图")
    private String capsuleimage;


}
