package com.example.Exception;


//自定义的token鉴权失败，需要重新登录错误类
public class NeedLoginException extends Throwable {
    private static final long serialVersionUID = 1L;

    private String msg;

    public NeedLoginException(String msg) {
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
