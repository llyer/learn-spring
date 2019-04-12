package com.example.learnredis;

import com.example.learnredis.mail.MailClient;
import com.example.learnredis.entity.User;
import com.example.learnredis.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnRedisApplicationTests {

	static Logger logger = LoggerFactory.getLogger(RedisService.class);

	@Autowired
	RedisTemplate redisTemplate;

	@Autowired
	MailClient mailClient;

    /**
     * 针对 Redis 的 list 数据类型进行测试，教程地址：https://www.cnblogs.com/fingerboy/p/6704812.html
     */
	@Test
	public void listTest() {
		User user = new User(1, "zhangsan", 18, null);
		User user2 = new User(2, "lisi", 18, null);

		//添加key
		redisTemplate.opsForList().rightPush("users", user);
		redisTemplate.opsForList().rightPush("users", user2);

		logger.info("从redis中获取key=users的值为：{}", redisTemplate.opsForList().range("users", 0, 10));

        System.out.println("是否有 Users 这个 Key = " + redisTemplate.hasKey("users"));

		//删除key
		redisTemplate.delete("users");

		System.out.println("是否有 Users 这个 Key = " + redisTemplate.hasKey("users"));

	}

	@Test
    public void sendTest() {
        mailClient.send();
    }


	@Test
	public void hashTest() {
		HashMap<String, String> map = new HashMap<>();
		redisTemplate.opsForHash().put("map2", "name", "zhangsan");
		redisTemplate.opsForHash().put("map2", "country", "china");

		System.out.println("是否有 Users 这个 Key = " + redisTemplate.hasKey("zhangsan"));
	}
}
