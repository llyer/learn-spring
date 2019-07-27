package me.liluyang.mybatis;


import me.liluyang.mybatis.generator.RoleMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleTests {

    @Autowired
    RoleMapper roleMapper;

//    @Test
//    public void testInsert() throws Exception {
//        roleMapper.insert(new Role(1L, "管理员"));
//        roleMapper.insert(new Role(2L, "用户"));
//    }

}
