package com.qdc.demoeurekaconsumer1.controllor;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class CounsumerControllor {
    //依赖restTemplate对象：拿数据
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/user")
    public String testalluser(){
        //通过接口取数据
        return restTemplate.getForObject("http://eureka-provider1/user/selectAll",String.class );
    }
    @RequestMapping(value = "/details/{userid}")
    public String testgetUserById(@PathVariable(value = "userid")String id){
        return restTemplate.getForObject("http://eureka-provider1/user/details?userid="+id,String.class);
    }
//    @RequestMapping(value = "/addUser")
//    public ResponseEntity<String> testaddUser(@ResponseBody User user){
//        return restTemplate.postForEntity("http://eureka-provider1/user/add=",user,String.class);
//    }
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @GetMapping(value = "sayHi")
    @HystrixCommand(fallbackMethod = "sayHiFallBack",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutinMilliseconds",value = "30000")
    })
    public String hello(@RequestParam (value="sleep_seconds")int sleep_seconds)throws InterruptedException{
        ServiceInstance serviceInstance=loadBalancerClient.choose("eureka-provider1");
        String url="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/sayHi?sleep_seconds="+sleep_seconds;
        System.out.println(url);
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject(url,String.class);

    }
    public String sayHiFallBack(int sleep_seconds){
        return "服务器暂时无法响应，请稍后再试";
    }

}
