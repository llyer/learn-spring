package com.example.learnredis.entity;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;

import java.util.Arrays;

/**
 *
 * 对象互相嵌套也会引发 java.lang.StackOverflowError
 *
 */
public class Main {

    public static void main (String[] args) {
        User user = new User();
        Role role = new Role();
        user.setId(1);
        user.setAge(10);
        user.setName("zhangsan");
        user.setRoles(Arrays.asList(role));

        role.setId(1);
        role.setName("admin");

        User userTemp = new User();
        BeanUtils.copyProperties(user,userTemp);
        role.setUsers(Arrays.asList(userTemp));

        // 报错
//        System.out.println(user);
        // 不报错
        System.out.println(JSONObject.toJSONString(user));
    }

}
