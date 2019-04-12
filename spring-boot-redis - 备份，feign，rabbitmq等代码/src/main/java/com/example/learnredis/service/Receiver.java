package com.example.learnredis.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Receiver {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RabbitListener(queues = "spring-boot-simple")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }
}
