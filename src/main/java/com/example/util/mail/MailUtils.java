package com.example.util.mail;


import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * @ClassName MailUtils
 * @Description 邮箱操作
 * @date 2021/12/14 20:36
 * @Version 1.0
 * @Author HJW
 */
public class MailUtils {

    public static void sendMail(String to) throws MessagingException {
        JavaMailSender sender = getJavaMailSender();
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(MailConfig.USERNAME);
        helper.setTo(to);
        helper.setSubject("注册邮件");
        helper.setSentDate(new Date());
        helper.setText("<h1>This is actual message</h1>", true);
        sender.send(message);
    }

    private static JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(MailConfig.HOST);
        sender.setProtocol(MailConfig.PROTOCOL);
        sender.setPort(MailConfig.PORT);
        sender.setDefaultEncoding(MailConfig.ENCODING);
        sender.setUsername(MailConfig.USERNAME);
        sender.setPassword(MailConfig.PASSWORD);
        return sender;
    }

}