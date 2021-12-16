package com.example.Exception;


//自定义的token鉴权失败错误,需要刷新错误类
public class TokenLoginException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String msg;

    public TokenLoginException(String msg) {
        super();
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
