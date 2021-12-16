package com.example.annotation;

import org.aspectj.lang.annotation.Aspect;

import java.lang.annotation.*;


//此注解用于用户鉴权
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented()
public @interface authentication {

    String value() default "";
}