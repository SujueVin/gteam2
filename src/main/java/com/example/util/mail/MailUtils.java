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
        helper.setFrom(MailConstants.USERNAME);
        helper.setTo(to);
        helper.setSubject("注册邮件");
        helper.setSentDate(new Date());
        helper.setText("<h1>This is actual message</h1>", true);
        sender.send(message);
    }


    public static JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(MailConstants.HOST);
        sender.setProtocol(MailConstants.PROTOCOL);
        sender.setPort(MailConstants.PORT);
        sender.setDefaultEncoding(MailConstants.ENCODING);
        sender.setUsername(MailConstants.USERNAME);
        sender.setPassword(MailConstants.PASSWORD);
        return sender;
    }
}