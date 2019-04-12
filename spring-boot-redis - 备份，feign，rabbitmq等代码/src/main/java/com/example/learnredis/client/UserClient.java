package com.example.learnredis.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


@Service
@FeignClient(name = "SERVICE-USER-ACCOUNT")
public interface UserClient {

    @GetMapping("/authorities/list")
    public Object findAuthorities();
}
