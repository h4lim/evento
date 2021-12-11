package com.evento.infrastructure.instance;

import com.evento.infrastructure.contract.InstanceContract;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailInstance implements InstanceContract.IEmailInstance {

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.properties.mail.smtp.transport.protocol}")
    private String protocol;

    @Value("${spring.mail.properties.mail.smtp.auth}")
    private boolean auth;

    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private boolean tlsEnable;

    @Value("${spring.mail.properties.mail.debug}")
    private boolean isDebugEnabled;

    @Override
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        mailSender.getJavaMailProperties().put("mail.transport.protocol", protocol);
        mailSender.getJavaMailProperties().put("mail.smtp.auth", auth);
        mailSender.getJavaMailProperties().put("mail.smtp.starttls.enable", tlsEnable);
        mailSender.getJavaMailProperties().put("mail.debug", isDebugEnabled);

        return mailSender;
    }
}
