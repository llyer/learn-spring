package com.example.learnredis.mail;

import org.springframework.stereotype.Component;

@Component
public class MailClient {

    public void send() {
        System.out.println("send mail success");
    }
}
