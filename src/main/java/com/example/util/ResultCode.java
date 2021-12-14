package com.example.util;


public enum ResultCode {
    SUCCESS(200,"成功"),
    PARAM_IS_INVALID(201,"参数不正确");

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
