package com.qdc.demoeurekaprovider1.controllor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortController {
    @Value("${server.port}")
    String port;
    @RequestMapping(value = "/port")
    public String testport(){
        return "hello,I'am form"+port;
    }
}
