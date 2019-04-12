package com.example.learnredis;

import com.example.learnredis.service.RedisService;
import com.example.learnredis.service.SimpleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@EnableCaching
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class LearnRedisApplication {

	public static void main(String[] args) {
//		ApplicationContext ctx = SpringApplication.run(LearnRedisApplication.class, args);
//		SimpleService simpleService = ctx.getBean(SimpleService.class);
//		simpleService.run();

//        RedisService redisService = ctx.getBean(RedisService.class);
//        redisService.run();

		SpringApplication.run(LearnRedisApplication.class, args);

	}
}
