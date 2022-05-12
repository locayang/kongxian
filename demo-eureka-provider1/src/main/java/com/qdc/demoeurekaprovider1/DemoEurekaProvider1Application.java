package com.qdc.demoeurekaprovider1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


//@EnableResourceServer
@EnableEurekaClient
@SpringBootApplication
public class DemoEurekaProvider1Application {
    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaProvider1Application.class, args);
    }
}
