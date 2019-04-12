package com.example.learnredis.service;

import com.example.learnredis.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    static Logger logger = LoggerFactory.getLogger(RedisService.class);

    @Autowired
    RedisTemplate redisTemplate;

    public void run() {

        User user = new User(1, "zhangsan", 18, null);

        logger.info("user：{}", user);

        //添加key
        redisTemplate.opsForValue().set("user:zhangsan", user);

        logger.info("从redis中获取key=user的值为：{}", redisTemplate.opsForValue().get("user:zhangsan"));

        //删除key
        redisTemplate.delete("user:zhangsan");

    }
}
