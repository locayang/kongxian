package com.qdc.demoeurekaconsumer1.clinet;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "UserServer")
public interface UserClinent {
    @RequestMapping(value = "/user/sayHi")
    public String hello();
}
