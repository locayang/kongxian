package com.qdc.demoeurekaauth_server1.Service.Impl;

import com.qdc.demoeurekaauth_server1.Pojo.Role;
import com.qdc.demoeurekaauth_server1.Pojo.User;
import com.qdc.demoeurekaauth_server1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user =  userService.GetUser(username);
        System.out.println(user+"aaaa");
        if(user==null || user.getId()<1){
            throw new UsernameNotFoundException ("username not found:"+username) ;
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                true,true,true,true,getGrantedAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(User user) {
        Set<Role> roles = new HashSet<Role>();
        Role r = new Role(1,"r");
        roles.add(r);
        user.setRoles(roles);
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for(Role role : user.getRoles()) {

            authorities.add(new SimpleGrantedAuthority("ROLE" + role.getName()));
        }

        return authorities;
    }
}
