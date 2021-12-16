package com.example.controller;


import com.example.Exception.NeedLoginException;
import com.example.Exception.TokenLoginException;
import com.example.util.Result;
import com.example.util.ResultCode;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


//这是集中自定义错误处理类
@ControllerAdvice
@ResponseBody
public class ExceptionHandle {

    //private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 500 - Token is invaild
     */
    @ExceptionHandler(TokenLoginException.class)
    public Result handleTokenException(Exception e) {
        //logger.error("Token is invaild...", e);
        return Result.error(ResultCode.TOKEN_IS_INVAILD);
    }

    /**
     * 500 - Token need update
     */
    @ExceptionHandler(NeedLoginException.class)
    public Result NeedLoginException(Exception e) {
        //logger.error("Token is invaild...", e);
        return Result.error(ResultCode.NEED_LOGIN);
    }


    /**
     * 404 - Internal Server Error
     */
    @ExceptionHandler(NotFoundException.class)
    public Result notHandleException(Exception e) {
        //logger.error("Not Found Error...", e);
        return Result.error(ResultCode.INTERFACE_NOT_exist);
    }
}