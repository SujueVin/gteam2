package com.example.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @ClassName RegisterParam
 * @Description 注册参数类
 * @date 2021/12/19 21:59
 * @Version 1.0
 * @Author HJW
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "RegisterParam对象",description = "")
public class RegisterParam {
    @ApiModelProperty(value = "用户名",required = true)
    private String username;
    @ApiModelProperty(value = "密码",required = true)
    private String password;
    @ApiModelProperty(value = "邮箱",required = true)
    private String email;
    @ApiModelProperty(value = "验证码",required = true)
    private String code;
}