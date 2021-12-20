package com.example.po;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户拥有游戏表
 * </p>
 *
 * @author su_jue
 * @since 2021-12-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Owngames对象", description="用户拥有游戏表")
public class Owngames implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userid;

    private String gameid;

    private String gamename;

    private String capsuleimage;


}
