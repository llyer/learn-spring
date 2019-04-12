package com.example.redis;

import com.example.redis.entity.User;
import com.example.redis.service.RedisService;
import com.example.redis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnRedisApplicationTests {

	static Logger logger = LoggerFactory.getLogger(RedisService.class);

	@Autowired
    UserService userService;

	@Autowired
	RedisTemplate redisTemplate;

    /**
     * 针对 Redis 的 list 数据类型进行测试，教程地址：https://www.cnblogs.com/fingerboy/p/6704812.html
     */
	@Test
	public void listTest() {
		User user = new User(1, "张三丰", 108, null);
		User user2 = new User(2, "曾阿牛", 18, null);

		logger.info(user.toString());

		//添加key
		redisTemplate.opsForList().rightPush("users", user.toString());
		redisTemplate.opsForList().rightPush("users", user2.toString());

		logger.info("从redis中获取key=users的值为：{}", redisTemplate.opsForList().range("users", 0, 10));

		logger.info("是否有 Users 这个 Key = " + redisTemplate.hasKey("users"));
	}

	/**
	 * Hash 数据结构测试
	 */
	@Test
	public void hashTest() {
		HashMap<String, String> map = new HashMap<>();
		redisTemplate.opsForHash().put("map2", "name", "zhangsan");
		redisTemplate.opsForHash().put("map2", "country", "china");

		System.out.println("是否有 map2 这个 Key = " + redisTemplate.hasKey("zhangsan"));
	}
}
