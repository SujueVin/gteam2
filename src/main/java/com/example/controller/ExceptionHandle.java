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
     * 500 - Token 相关
     */
    @ExceptionHandler(InvalidJwtException.class)//jose4j错误类，不用自定义了
    public Result InvalidJwtException(InvalidJwtException e) {
        //logger.error("Token is invaild...", e);
        //通过获取jose4j错误类内部信息进行判断,返回不同的错误码


        //能够来到这里说明token不对或者过期
        //两种token不对都不需要对数据库进行修改，accesstoken过期也不需要对数据库修改
        //只有在accessToken过期的时候才需要返回刷新token的提示
        //只有在refreshToken过期的时候才需要返回重新登录的提示，并且由于mongodb自带过期时间，因此不需要自动删除
        if (e.hasExpired())
        {
            //accesstoken过期,前端需要拿refreshtoken访问refreshtoken接口
            try {
                if ("accessTokenWebKey".equals(e.getJwtContext().getJwtClaims().getJwtId())){//查看过期类型是否是accesstoken，是就发送过期
                    return Result.error(ResultCode.TOKEN_NEED_REFRESH);
                } else if ("refreshTokenWebKey".equals(e.getJwtContext().getJwtClaims().getJwtId())){
                    return Result.error(ResultCode.NEED_LOGIN);
                } else {
                    System.out.println("Token Type wrong ___ ExceptionHandle,InvalidJwtException");
                }
            } catch (MalformedClaimException malformedClaimException) {
                malformedClaimException.printStackTrace();
            }
        }
        //其他情况，token不对
        return Result.error(ResultCode.TOKEN_IS_INVALID);
    }

    /**
     * 404 - Internal Server Error
     */
    @ExceptionHandler(NotFoundException.class)
    public Result notHandleException(Exception e) {
        //logger.error("Not Found Error...", e);
        return Result.error(ResultCode.INTERFACE_NOT_EXIST);
    }

}