package com.liluyang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicTest {

	@Test
	public void contextLoads() {

		User user = new User();
		Role role = new Role();
		user.setId("1");
		user.setName("zhangsan");

		role.setId("1");
		role.setLabel("admin");
		role.setUser(user);
	}

}
