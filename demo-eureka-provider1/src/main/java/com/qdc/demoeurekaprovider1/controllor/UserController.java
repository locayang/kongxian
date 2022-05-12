package com.qdc.demoeurekaprovider1.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.qdc.demoeurekaprovider1.po.User;
import com.qdc.demoeurekaprovider1.Service.UserService;

import java.util.List;

//返回{jison}格式 controller返回页面
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    //addUser方法接受前段传过来的数据也是json格式
    //把json格式转换为user
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    private boolean addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @RequestMapping(value = "/upadte",method = RequestMethod.PUT)
    private boolean updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    @RequestMapping(value = "/delect",method = RequestMethod.DELETE)
    private boolean delectUser(@RequestParam(value = "username",required = true) String name){
        return userService.delectUser(name);
    }
    @RequestMapping(value = "/selectById",method = RequestMethod.GET)
    private User selectUserById(@RequestParam(value = "userid",required = true) String id){
        return userService.SelectUserById(id);
    }
    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    private List<User> selectAll(){
        return userService.SelectAll();
    }


    @Value("${spring.cloud.client.ip-address}")
    String ipaddr;
    @Value("${server.port}")
    int port;
    @RequestMapping(value="/sayHi",method=RequestMethod.GET)
    public String hello(@RequestParam(value = "sleep_seconds",required = true)int sleep_seconds)throws InterruptedException
    {
        System.out.println("休眠时间"+sleep_seconds);
        Thread.sleep(sleep_seconds*1000);
        return "hello,我在"+ipaddr+":"+port;
    }


}
