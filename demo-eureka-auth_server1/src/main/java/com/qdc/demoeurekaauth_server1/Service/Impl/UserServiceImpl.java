package com.qdc.demoeurekaauth_server1.Service.Impl;

import com.qdc.demoeurekaauth_server1.Mapper.UserMapper;
import com.qdc.demoeurekaauth_server1.Pojo.User;
import com.qdc.demoeurekaauth_server1.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserMapper userMapper;
    @Override
    public User GetUser(String username) {
        return userMapper.findByUsername(username);
    }
}
