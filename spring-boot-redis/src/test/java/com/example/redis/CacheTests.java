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
public class CacheTests {

	static Logger logger = LoggerFactory.getLogger(RedisService.class);

	@Autowired
    UserService userService;

    @Test
    public void getTest() throws Exception {
        User u1 = userService.get(11);
        System.out.println("第一次查询：" + u1.getAge());
    }

	@Test
	public void getTest2() throws Exception {
		User u1 = userService.get(1);
		System.out.println("第一次查询：" + u1.getAge());

		User u2 = userService.get(1);
		System.out.println("第二次查询：" + u2.getAge());

		u1.setAge(23);
		userService.save(u1);
		User u3 = userService.get(1);
		System.out.println("第三次查询：" + u3.getAge());
	}

    @Test
    public void getTest3() throws Exception {
        User u1 = new User();
        u1.setId(11);
        u1.setName("张三丰");
        u1.setAge(108);
        userService.save(u1);
        User u3 = userService.get(11);
        System.out.println("第一次查询：" + u3.getAge());
    }
}
