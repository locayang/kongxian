package com.qdc.demoeurekaconsumserfeign.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserClient {
    @RequestMapping("/post")
    public String hello();
    @RequestMapping("/user/sayHi")
    public String hello(@RequestParam(value = "sleep_seconds")int sleep_seconds);
}
