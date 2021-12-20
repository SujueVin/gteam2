package com.example.aspect;

import com.example.util.HttpContextUtil;
import com.example.util.token.TokenConstant;
import com.example.util.token.TokenUtil;
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

        //这里只需要进行accessToken的鉴权，因为资源访问不需要访问refreshToken

        // 从 request header 中获取当前 token
        String accessToken = HttpContextUtil.getHttpServletRequest().getHeader(TokenConstant.ACCESS_TOKEN_NAME);
        //检验accesstoken是否过期,是否符合格式，不符合要求或者过期的话util类将会自动抛出异常
        TokenUtil.checkJwt(accessToken, TokenConstant.tokenType.ACCESS_TOKEN);

        //执行方法
        Object result = point.proceed();

        //执行时长(毫秒)
        //long time = System.currentTimeMillis() - beginTime;

        return result;
    }
}
