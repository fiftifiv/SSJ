package com.shkiddi_school.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;


@Configuration
public class MailConfig {
    @Value("${spring.mail.host}")
    String host;
    @Value("${spring.mail.username}")
    String username;
    @Value("${spring.mail.password}")
    String passowrd;
    @Value("${spring.mail.port}")
    int port;
    @Value("${spring.mail.protocol}")
    String protocol;
    @Value("${mail.debug}")
    String debug;

    @Bean
    public JavaMailSenderImpl getMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(host);
        javaMailSender.setUsername(username);
        javaMailSender.setPassword(passowrd);

        Properties javaMailProperties = javaMailSender.getJavaMailProperties();

        javaMailProperties.setProperty("mail.transport.protocol",protocol);
        javaMailProperties.setProperty("mail.debug",debug);

        javaMailSender.setJavaMailProperties(javaMailProperties);

        return javaMailSender;
    }
}
