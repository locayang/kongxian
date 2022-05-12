package com.qdc.demoeurekaauth_server1;

import com.alibaba.druid.pool.DruidDataSource;
import com.qdc.demoeurekaauth_server1.Service.Impl.UserDetailsServiceImpl;
import com.qdc.demoeurekaauth_server1.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoEurekaAuthServerApplicationTests {
    @Autowired
    private DruidDataSource druidDataSource;
    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Test
    void contextLoad(){
        System.out.println(userService.GetUser("admin"));
    }
    @Test
    void s2(){
        System.out.println(userDetailsService.loadUserByUsername("admin"));
    }
    @Test
    void contextLoads() {
        System.out.println(druidDataSource);
    }

}
