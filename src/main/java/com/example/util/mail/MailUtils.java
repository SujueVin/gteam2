package com.example.util.mail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

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

    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String to, String code) throws MessagingException {
        JavaMailSender sender = javaMailSender;
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(MailConstants.USERNAME);
        helper.setTo(to);
        helper.setSubject("账号激活");
        helper.setSentDate(new Date());
        //邮件内容
        Context context = new Context();
        String mail = templateEngine.process("mail", context);
        helper.setText(mail, true);
        sender.send(message);
    }


}