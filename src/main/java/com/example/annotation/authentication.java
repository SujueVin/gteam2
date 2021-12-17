package com.example.annotation;

import java.lang.annotation.*;


//此注解用于用户鉴权
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented()
public @interface authentication {

    String value() default "";
}