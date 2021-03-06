package com.example.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author su_jue
 * @since 2021-12-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="User对象", description="用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    private Integer userid;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码(加盐并加密)")
    private String password;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "注册邮箱")
    private String email;

    @ApiModelProperty(value = "手机号码")
    private Long phone;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ctime;

    @ApiModelProperty(value = "用户状态，0为正常，1为未验证，2为受限，3为删除")
    private Integer stat;

    @ApiModelProperty(value = "用户简介")
    private String introduction;

    @ApiModelProperty(value = "拥有游戏数量")
    private Integer gamenum;

    @ApiModelProperty(value = "游戏总时间")
    private Long playtime;

    @ApiModelProperty(value = "用户头像")
    private String userimage;

}
