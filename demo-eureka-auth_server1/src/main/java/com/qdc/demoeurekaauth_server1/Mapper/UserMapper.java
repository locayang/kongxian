package com.qdc.demoeurekaauth_server1.Mapper;


import com.qdc.demoeurekaauth_server1.Pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select *from springcloud_user where username=#{username}")
    public User findByUsername(String username);
}
