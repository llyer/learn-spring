package me.liluyang.jpa;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import me.liluyang.jpa.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@Slf4j
@RunWith(SpringRunner.class)
public class DateTests {

    @Test
    public void testInsert() throws Exception {
        User user = new User();
        user.setUsername("john");
        user.setLastLoginAt(new Date());
        user.setUpdateAt(new Date());
        user.setCreateAt(new Date());

        // 三个输出分别是："lastLoginAt":1564208521736,"updateAt":"2019-07-27 06:22:01","createAt":"2019-07-27 14:22:01"
        // 如果我们要格式化输出时间的话一定要指定合适的时区
        log.info("date:" + new ObjectMapper().writeValueAsString(user));
    }
}
