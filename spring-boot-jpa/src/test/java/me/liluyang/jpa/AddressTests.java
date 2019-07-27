package me.liluyang.jpa;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.liluyang.jpa.dto.UserView;
import me.liluyang.jpa.entity.Address;
import me.liluyang.jpa.repository.AddressRepository;
import me.liluyang.jpa.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressTests {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void testInsert() throws Exception {
        addressRepository.save(new Address("1", "深圳"));
    }

    @Test
    public void testQuery() throws Exception {
        System.out.println(userRepository.findClassById("1").toString());
    }

    /**
     * 基于接口的投影
     * @throws Exception
     */
    @Test
    @Transactional
    public void findView() throws Exception {
        UserView view = userRepository.findViewById("1");
        System.out.println(new ObjectMapper().writeValueAsString(view));
    }

    @Test
    public void findView2() throws Exception {
        System.out.println(userRepository.findViewById("1").toString());
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
