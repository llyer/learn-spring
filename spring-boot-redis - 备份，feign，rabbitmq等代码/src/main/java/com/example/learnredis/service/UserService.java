package com.example.learnredis.service;

import com.example.learnredis.entity.User;
import com.example.learnredis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> list() {
        System.out.println("进入 list users service 方法");
        return userRepository.findAll();
    }

    /**
     * 查询用户，并且值缓存用户ID小于10的用户
     * @param id
     * @return
     */
    @Cacheable(value = "user", key = "#id", condition = "#id < 10")
    public User get(Integer id) {
        System.out.println("进入 service get 方法");
        return userRepository.findById(id).orElse(null);
    }

    /**
     * 一般用用于添加或者更新，如果有就更新，如果没有缓存就添加一个缓存
     * @param user
     * @return
     */
    @CachePut(value = "user", key = "#user.id")
    public User save(User user) {
        System.out.println("进入 service save 方法");
        return userRepository.save(user);
    }

    @CachePut(value = "user", key = "#user.id")
    public User update(User user) {
        System.out.println("进入 service update 方法");
        return userRepository.save(user);
    }

    /**
     * Evict 清除缓存，一般用在删除方法之上，在删除时，也将缓存数据清空
     * @param id
     */
    @CacheEvict(value = "user", key = "#id")
    public void delete(Integer id) {
        System.out.println("进入 service delete 方法");
        userRepository.deleteById(id);
    }
}
