package com.qdc.demoeurekaconsumer1.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
//表名配置类
@Configuration
public class Ribbonconfig {
    //做成bean文件
    @Bean
    //加载均衡
    @LoadBalanced
    //为了调用服务对象，生成builder对象
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
