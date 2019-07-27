package me.liluyang.jpa;

import me.liluyang.jpa.entity.Role;
import me.liluyang.jpa.repository.RoleRepository;
import me.liluyang.jpa.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleTests {

    @Resource
    RoleRepository roleRepository;

    @Resource
    private UserRepository userRepository;

    @Test
    public void testInsert() throws Exception {
        roleRepository.save(new Role("1", "管理员", userRepository.findAll()));
        roleRepository.save(new Role("2", "用户", userRepository.findAll()));
    }

}
