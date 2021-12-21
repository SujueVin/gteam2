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
 * @Date: 2021/12/18 16:54
 */


//此类仅用于展示个人个人空间信息页面
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="UserDetailShowDTO", description="用户空间详细信息，用于展示页面展示，可有邮箱等不可修改信息")
public class UserDetailShowDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    private Integer userid;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "手机号码")
    private Long phone;

    @ApiModelProperty(value = "用户简介")
    private String introduction;

    @ApiModelProperty(value = "用户头像")
    private String userimage;

    //-----------------下面将是不可修改的部分
    @ApiModelProperty(value = "注册邮箱")
    private String email;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ctime;

}
