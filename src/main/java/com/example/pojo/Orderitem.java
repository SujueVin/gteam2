package com.example.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 每个订单对应的订单详细内容
 * </p>
 *
 * @author su_jue
 * @since 2021-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Orderitem对象", description="每个订单对应的订单详细内容")
public class Orderitem implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "游戏id")
    private Integer gid;

    @ApiModelProperty(value = "购买时价格")
    private Double price;

    @ApiModelProperty(value = "激活码")
    private Integer code;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime ctime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime utime;


}
