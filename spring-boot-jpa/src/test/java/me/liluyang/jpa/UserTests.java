package me.liluyang.jpa;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.liluyang.jpa.dto.UserDto;
import me.liluyang.jpa.dto.UserDto2;
import me.liluyang.jpa.dto.UserView;
import me.liluyang.jpa.dto.UserView2;
import me.liluyang.jpa.entity.User;
import me.liluyang.jpa.repository.RoleRepository;
import me.liluyang.jpa.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testInsert() throws Exception {
        userRepository.save(new User("1", "赵敏"));
        userRepository.save(new User("2", "张无忌"));
        userRepository.save(new User("3", "灭绝师太"));
        Assert.assertEquals(3, userRepository.findAll().size());

//        userMapper.insert(new User(1L, "渡劫"));
//        userMapper.insert(new User(2L, "渡厄"));
//        userMapper.insert(new User(3L, "渡难"));
    }

    @Test
    public void findDto() throws Exception {
        UserDto dto = userRepository.findClassById("1");
        System.out.println(new ObjectMapper().writeValueAsString(dto));
    }

    @Test
    public void findDto2() throws Exception {
        UserDto2 dto = userRepository.findClass2ById("1");
        System.out.println(new ObjectMapper().writeValueAsString(dto));
    }

    /**
     * 基于接口的投影
     *
     * 如果投影没有嵌套，那么效率很高，投影有什么字段就返回什么值，但是嵌套之后，效率变得不是很高，而且查询了两次，sql 稍微有一些区别
     *
     * @throws Exception
     */
    @Test
    public void findView() throws Exception {
        UserView view = userRepository.findViewById("1");
        System.out.println(new ObjectMapper().writeValueAsString(view));
    }

    @Test
    public void findView2() throws Exception {
        UserView2 view = userRepository.findView2ById("1");
        System.out.println(new ObjectMapper().writeValueAsString(view));
    }

    /**
     * 使用 sql 查询的时候是否可以使用投影
     * @throws Exception
     */
    @Test
    @Transactional
    public void findSql() throws Exception {
//        UserView view = userRepository.findSqlById("1");
//        System.out.println(new ObjectMapper().writeValueAsString(view));
    }



    /**
     * 动态映射
     *
     * 动态映射就是
     *
     * @throws Exception
     */
    @Test
    public void findByDynamic() throws Exception {
        User user = userRepository.findByUsername("张无忌", User.class);
        UserDto dto = userRepository.findByUsername("张无忌", UserDto.class);
        UserView view = userRepository.findByUsername("张无忌", UserView.class);

        System.out.println(new ObjectMapper().writeValueAsString(user));
        System.out.println(new ObjectMapper().writeValueAsString(dto));
        System.out.println(new ObjectMapper().writeValueAsString(view));
    }

}
