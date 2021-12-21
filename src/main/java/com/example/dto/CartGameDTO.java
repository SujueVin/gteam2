package com.example.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: tt
 * @Date: 2021/12/21 11:38
 */


//此类用于cart中游戏列表的展示类
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="CartListDTO", description="Cart中game信息传输")
public class CartGameDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "游戏ID")
    private Long gameid;

    @ApiModelProperty(value = "游戏名字")
    private String gamename;

    @ApiModelProperty(value = "正常价格")
    private Double price;

    @ApiModelProperty(value = "打折后价格")
    private Double discount;

    @ApiModelProperty(value = "游戏简略图")
    private String capsuleimage;


}
