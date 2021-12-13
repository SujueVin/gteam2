package com.example.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 游戏种类表
 * </p>
 *
 * @author su_jue
 * @since 2021-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Kind对象", description="游戏种类表")
public class Kind implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "种类ID")
    private Integer id;

    @ApiModelProperty(value = "种类名字")
    private String name;


}
