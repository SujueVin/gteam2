package com.example.util;

import lombok.Data;

import java.io.Serializable;




//返回类
@Data
public class Result<T> implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success;

    /**
     * 描述
     */
    private String message;

    /**
     * 返回代码
     */
    private Integer code;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * 结果对象
     */
    private T data;


    //下面是相应的静态方法

    //返回成功

}
