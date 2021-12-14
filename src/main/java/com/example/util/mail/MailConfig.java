package com.example.util.mail;

/**
 * @ClassName MailConfig
 * @Description mail的基本信息
 * @date 2021/12/14 20:50
 * @Version 1.0
 * @Author HJW
 */
public class MailConfig {
    /**
     * 发送邮件的主机种类
     */
    static String QQ_HOST = "smtp.qq.com";
    static String WY_HOST = "smtp.163.com";
    /**
     * 基础配置
     */
    static String HOST = WY_HOST;
    static String PROTOCOL = "smtp";    //使用的传输协议
    static String ENCODING = "UTF-8";   //编码格式
    static String USERNAME = "邮箱地址";    //发件人
    static String PASSWORD = "";    //授权码
    static int PORT = 25;  //服务器端口号
}
