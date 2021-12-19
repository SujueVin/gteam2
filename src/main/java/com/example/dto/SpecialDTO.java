package com.example.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author: tt
 * @Date: 2021/12/19 16:31
 */

//此类用于传输首页中的特惠滑动框
//前端将使用此接口获得每日的SpecialDTO类数组
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SpecialDTO", description="游戏特惠信息")
public class SpecialDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "特惠游戏价格")
    private Double price;

    @ApiModelProperty(value = "特惠游戏打折后价格")
    private Double discount;

    @ApiModelProperty(value = "特惠游戏简略图")
    private String capsuleimage;

}
