package com.example.util.mail;


import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName MailUtils
 * @Description 邮箱操作
 * @date 2021/12/14 20:36
 * @Version 1.0
 * @Author HJW
 */
public class MailUtils {

    public static void sendMail(String to, String code) throws MessagingException {
        JavaMailSender sender = getJavaMailSender();
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(MailConstants.USERNAME);
        helper.setTo(to);
        helper.setSubject("账号激活");
        helper.setSentDate(new Date());
        String content = "<h1>这是一封激活邮件</h1>" +
                "<h3><a href=\"http://127.0.0.1:8080/user/checkRegister/" +
                code + "\">账号激活</a></h3>";
        helper.setText(content, true);
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