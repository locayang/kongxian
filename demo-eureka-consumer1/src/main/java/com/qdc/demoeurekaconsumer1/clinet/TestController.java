package com.qdc.demoeurekaconsumer1.clinet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    private UserClinent userClinent;
    @RequestMapping("/sayHi")
    public String hello(){
        return userClinent.hello();
    }
}
