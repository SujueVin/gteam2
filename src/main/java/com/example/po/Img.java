package com.example.po;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 游戏图片映射表
 * </p>
 *
 * @author su_jue
 * @since 2021-12-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Img对象", description="游戏图片映射表")
public class Img implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "游戏ID")
    private Integer game;

    @ApiModelProperty(value = "图片路径")
    private String img;


}
