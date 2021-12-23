package com.example.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

//此类用于传输User类中非隐私信息，用于公开的用户空间
//只用于展示，不用于修改
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="UserMsgDTO", description="用户非隐私信息")
public class UserMsgDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "对外展示昵称")
    private Integer userid;

    @ApiModelProperty(value = "对外展示昵称")
    private String nickname;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ctime;

    @ApiModelProperty(value = "用户简介")
    private String introduction;

    @ApiModelProperty(value = "用户头像图片位置")
    private String userimage;

}
