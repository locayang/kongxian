package com.qdc.demoeurekaconsumserfeign.service;

public class feignClientFallback implements UserClient{

    @Override
    public String hello() {
        return "";
    }

    @Override
    public String hello(int sleep_seconds) {
        return "hi,容错保护机制已启动";
    }
}
