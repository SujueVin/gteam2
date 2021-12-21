package com.example.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: tt
 * @Date: 2021/12/18 16:54
 */


//此类仅用于修改个人个人空间信息页面
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="UserDetailDTO", description="用户空间详细信息，用于修改页面展示")
public class UserDetailDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "手机号码")
    private Long phone;

    @ApiModelProperty(value = "用户简介")
    private String introduction;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "用户头像图片位置")
    private String userimage;


}
