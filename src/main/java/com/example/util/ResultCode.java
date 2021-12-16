package com.example.util;


public enum ResultCode {
    SUCCESS(200,"成功"),
    PARAM_IS_INVALID(201,"参数不正确"),
    INTERFACE_NOT_exist(404,"该接口不存在"),
    TOKEN_IS_INVAILD(500,"登录token鉴权失败"),
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
