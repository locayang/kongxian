package com.qdc.demoeurekaconsumer1;

import com.qdc.demoeurekaconsumer1.Utils.HttpClientWithBasicAuth;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.HashMap;
import java.util.Map;
@EnableHystrix
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class DemoEurekaConsumer1Application {
    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaConsumer1Application.class,args);
        HttpClientWithBasicAuth auth=new HttpClientWithBasicAuth();
        String url="http://localhost:8081/oath/token";
        Map<String,String> formData=new HashMap<>();
        formData.put("grant_type","client_credentials");
        formData.put("grant","all");
        String result=auth.send(url,"test","123456",formData);

    }

}
