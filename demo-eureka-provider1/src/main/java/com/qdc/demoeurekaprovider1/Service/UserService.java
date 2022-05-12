package com.qdc.demoeurekaprovider1.Service;

import com.qdc.demoeurekaprovider1.po.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    public User SelectUserById(String id){
        return new User("aaa","123","zip");
    }
    public List<User> SelectAll(){
        List<User> userList =new ArrayList<>();
        User user1=new User("aaa","123","zab");
        User user2=new User("bbb","123","zab");
        userList.add(user1);
        userList.add(user2);
        return userList;
    }
    public Boolean addUser(User u){
        return true;
    }
    public Boolean updateUser(User u){
        return true;
    }
    public Boolean delectUser(String name){
        return true;
    }
}
