package com.example.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 游戏标签表
 * </p>
 *
 * @author su_jue
 * @since 2021-12-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Tag对象", description="游戏标签表")
public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标签ID")
    @TableId(value = "tagid", type = IdType.AUTO)
    private Integer tagid;

    @ApiModelProperty(value = "标签名字")
    private String name;


}
