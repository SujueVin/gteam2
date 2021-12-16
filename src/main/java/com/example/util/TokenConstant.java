package com.example.util;


/**
 * 此类规定了不同种类token在head中的对应存放字段
 * 此类还存放了和token有关的常量数据
 */

public class TokenConstant {

    /**
     * accessToken有效期（秒）
     * 1h
     */
    public static final long ACCESS_TOKEN_EXPIRES_HOUR = 7200;


    /**
     * refreshToken有效期（秒）
     * 7天
     */
    public static final long REFRESH_TOKEN_EXPIRES_HOUR = 604800;



    /**  存放AccessToken的header字段 */
    public static final String ACCESS_TOKEN_NAME = "Token1";

    public static final String REFRESH_TOKEN_NAME = "Token2";

}