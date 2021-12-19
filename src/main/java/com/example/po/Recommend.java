package com.example.po;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 游戏推荐表，人工设定
 * </p>
 *
 * @author su_jue
 * @since 2021-12-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Recommend对象", description="游戏推荐表，人工设定")
public class Recommend implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer gameid;


}
