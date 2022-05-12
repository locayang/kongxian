package com.qdc.demoeurekaconsumserfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
@EnableEurekaClient
@EnableHystrix
@SpringBootApplication
public class DemoEurekaConsumserFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaConsumserFeignApplication.class, args);
    }

}
