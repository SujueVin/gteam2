package com.example.aspect;

import com.example.Exception.NeedLoginException;
import com.example.Exception.TokenLoginException;
import com.example.util.HttpContextUtil;
import com.example.util.TokenConstant;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


//此切面类进行接口鉴权，对于所有的使用@authentication注解的方法进行提前鉴权
@Aspect
@Component
public class authenticationAspect {

    @Pointcut("@annotation(com.example.annotation.authentication)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        //long beginTime = System.currentTimeMillis();

        // 从 request header 中获取当前 token
        String accessToken = HttpContextUtil.getHttpServletRequest().getHeader(TokenConstant.ACCESS_TOKEN_NAME);
        //检验accesstoken是否过期，是就抛出异常，告知前端使用refreshtoken获取新token
        if (false){
            throw new TokenLoginException("accesstoken过期，需要刷新token");
        }

        //检验refreshtoken是否过期
        String refreshToken = HttpContextUtil.getHttpServletRequest().getHeader(TokenConstant.REFRESH_TOKEN_NAME);
        //如果过期，将db表中对应uid项删除，返回没有权限，需要重新登录

        if (false){
            throw new NeedLoginException("refreshtoken过期，需要重新登录");
        }

        //如果没有过期，和db中对应uid项的token对比，如果不是同一个，返回没有权限，需要重新登录
        if (false){
            throw new NeedLoginException("不是同一个token，可能被盗号");
        }

        //执行方法
        Object result = point.proceed();

        //执行时长(毫秒)
        //long time = System.currentTimeMillis() - beginTime;

        return result;
    }
}
