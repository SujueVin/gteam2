package com.example.util.Result;


public enum ResultCode {
    SUCCESS(200,"成功"),
    PARAM_IS_INVALID(201,"参数不正确"),
    IS_NULL(201,"用户名或者密码不能为空"),
    INTERFACE_NOT_EXIST(404,"该接口不存在"),
    TOKEN_IS_INVALID(500,"token错误"),
    TOKEN_NEED_REFRESH(500,"token需要刷新"),
    NOT_FIND(500,"请求数据无法找到"),
    NEED_LOGIN(500,"需要登录");


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
