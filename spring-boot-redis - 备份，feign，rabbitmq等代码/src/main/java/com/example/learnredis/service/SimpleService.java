package com.example.learnredis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SimpleService {

    static Logger logger = LoggerFactory.getLogger(SimpleService.class);

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void run() {

        // 获得链接 Redis 的工厂类
        logger.info("redis连接工厂：{}", stringRedisTemplate.getConnectionFactory());

        //添加key
        stringRedisTemplate.opsForValue().set("user", "张三");

        //获取key
        logger.info("从redis中获取key=user的值为：{}", stringRedisTemplate.opsForValue().get("user"));

        //删除key
        stringRedisTemplate.delete("user");

    }
}
