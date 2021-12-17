package com.example.util.token;


/**
 * 此类规定了不同种类token在head中的对应存放字段
 * 此类还存放了和token有关的常量数据
 */

public class TokenConstant {

    /**
     * accessToken有效期（分钟）
     * 1h
     */
    public static final long ACCESS_TOKEN_EXPIRES_HOUR = 60;


    /**
     * refreshToken有效期（分钟）
     * 7天
     */
    public static final long REFRESH_TOKEN_EXPIRES_HOUR = 10080;

    /**  存放AccessToken的header字段 */
    public static final String ACCESS_TOKEN_NAME = "Token1";

    public static final String REFRESH_TOKEN_NAME = "Token2";

    //不需要内部存储数据，因此直接字符串
    public enum tokenType{
        ACCESS_TOKEN,
        REFRESH_TOKEN
    }
}