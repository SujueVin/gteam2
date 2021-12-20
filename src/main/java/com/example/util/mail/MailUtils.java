package com.example.util.mail;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

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
@Configuration
public class MailUtils {


    public void sendMail(String to, String code) throws MessagingException {
        JavaMailSender sender = javaMailSender();
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(MailConstants.USERNAME);
        helper.setTo(to);
        helper.setSubject("账号激活");
        helper.setSentDate(new Date());
        //邮件内容
        TemplateEngine templateEngine = new TemplateEngine();

        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");
        resolver.setCacheable(false);
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setForceTemplateMode(true);
        templateEngine.setTemplateResolver(resolver);
        Context context = new Context();
        context.setVariable("code", code);
        String mail = templateEngine.process("mail", context);
        helper.setText(mail, true);
        sender.send(message);
    }
    @Bean
    public  JavaMailSender javaMailSender(){
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