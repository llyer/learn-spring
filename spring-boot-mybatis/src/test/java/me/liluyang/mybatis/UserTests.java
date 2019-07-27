package me.liluyang.mybatis;

import me.liluyang.mybatis.generator.User;
import me.liluyang.mybatis.generator.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() throws Exception {
//        userMapper.insert(new User(1L, "赵敏"));
//        userMapper.insert(new User(2L, "张无忌"));
//        userMapper.insert(new User(3L, "灭绝师太"));
//        Assert.assertEquals(3, userMapper.getAll().size());

//        userMapper.insert(new User(1L, "渡劫"));
//        userMapper.insert(new User(2L, "渡厄"));
//        userMapper.insert(new User(3L, "渡难"));

        List<User> all = userMapper.getAll();

        System.out.println(all);

//        userMapper.insertByIncreasedKey(new User(1L, "渡难"));
    }

    @Test
    public void testQuery() throws Exception {
        List<User> users = userMapper.getAll();
        System.out.println(users.toString());
    }

//    @Test
//    public void testUpdate() throws Exception {
//        User user = userMapper.getOne(1L);
//        System.out.println(user.toString());
//        user.setUsername("张三丰");
//        userMapper.update(user);
//        Assert.assertTrue(("张三丰".equals(userMapper.getOne(1L).getUsername())));
//    }

//    @Test
//    public void testDelete() throws Exception {
//        userMapper.delete(5L);
//    }
}
