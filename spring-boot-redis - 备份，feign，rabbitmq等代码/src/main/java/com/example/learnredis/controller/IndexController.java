package com.example.learnredis.controller;

import com.example.learnredis.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/index")
@RestController
public class IndexController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    UserClient userClient;

    @GetMapping("")
    public String get() {
        return "hello world";
    }

}
