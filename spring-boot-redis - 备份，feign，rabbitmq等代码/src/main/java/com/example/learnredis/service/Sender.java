package com.example.learnredis.service;

import com.example.learnredis.config.RabbitMQConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        System.out.println("李鲁杨 发送消息...");
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, "你好， 李鲁杨!");
    }
}
