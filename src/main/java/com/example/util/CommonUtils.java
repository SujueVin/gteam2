package com.example.util;

import java.util.UUID;

/**
 * @ClassName CommonUtils
 * @Description 公共方法
 * @date 2021/12/16 21:21
 * @Version 1.0
 * @Author HJW
 */
public class CommonUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}