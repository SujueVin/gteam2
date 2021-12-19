package com.example.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
    @TableId(value = "userid", type = IdType.AUTO)
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
    private LocalDateTime ctime;

    @ApiModelProperty(value = "用户状态，0为正常，1为未验证，2为受限，3为删除")
    private Integer stat;

    @ApiModelProperty(value = "用户简介")
    private String introduction;

    @ApiModelProperty(value = "拥有游戏数量")
    private Integer gamenum;

    @ApiModelProperty(value = "游戏总时间")
    private Long playtime;


}
