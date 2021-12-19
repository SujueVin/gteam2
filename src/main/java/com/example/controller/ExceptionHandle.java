package com.example.controller;



import com.example.util.Result.Result;
import com.example.util.Result.ResultCode;
import org.apache.ibatis.javassist.NotFoundException;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


//这是集中自定义错误处理类
@ControllerAdvice
@ResponseBody
public class ExceptionHandle {

    //private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);


    /**
     * 500 - Token
     */
    @ExceptionHandler(InvalidJwtException.class)//jose4j错误类，不用自定义了
    public Result InvalidJwtException(InvalidJwtException e) {
        //logger.error("Token is invaild...", e);
        //通过获取jose4j错误类内部信息进行判断,返回不同的错误码

        //同时需要对mongodb数据库进行操作
        if (e.hasExpired())
        {
            //accesstoken过期,前端需要拿refreshtoken访问refreshtoken接口
            try {
                if ("accessTokenWebKey".equals(e.getJwtContext().getJwtClaims().getJwtId())){//查看过期类型是否是accesstoken，是就发送过期
                    return Result.error(ResultCode.TOKEN_IS_INVAILD);
                }
            } catch (MalformedClaimException malformedClaimException) {
                malformedClaimException.printStackTrace();
            }
        }
        //refreshtoken过期,前端需要直接进行登录
        //accesstoken用户不对,前端需要直接进行登录
        //refreshtoken用户不对,前端需要直接进行登录
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