package com.example.learnredis;

import com.example.learnredis.service.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTests {

	static Logger logger = LoggerFactory.getLogger(RabbitMQTests.class);

	@Autowired
	private Sender sender;

	@Test
	public void send() throws Exception {
		sender.send();
	}
}
