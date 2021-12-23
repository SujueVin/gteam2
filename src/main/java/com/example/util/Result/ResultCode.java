package com.example.util.Result;


public enum ResultCode {
    SUCCESS(200,"接口访问成功"),
    PARAM_IS_INVALID(201,"参数不正确"),
    IS_NULL(202,"用户名或者密码不能为空"),
    SUCCESS_CHANGE_PASSWORD(203,"更改密码成功请重新登录"),
    INTERFACE_NOT_EXIST(404,"该接口不存在"),
    NEED_LOGIN(501,"刷新码无效,需要登录"),
    TOKEN_IS_INVALID(502,"accessToken错误"),
    TOKEN_NEED_REFRESH(503,"accessToken过期,需要刷新"),
    NOT_FIND(504,"请求数据无法找到"),
    USERNAME_IS_INVALID(201,"用户名已经被注册"),
    EMAIL_IS_INVALID(201,"邮箱已经被用于注册"),
    NOT_EXISTS(404,"资源不存在"),
    MYBATIS_EXCEPTION(501,"数据库异常"),
    HAS_EXISTED_IN_OWNGAMES(405,"游戏已经购买"),
    HAS_EXISTED_IN_CART(405,"游戏已经在购物车内"),
    CODE_NOT_EXIST(404,"输入验证码不存在"),;


    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
