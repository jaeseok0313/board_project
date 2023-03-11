package com.gma.gmagame.SecurityConfig;

import com.gma.gmagame.mapper.UserMapper;
import com.gma.gmagame.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomLoadUserByUsername implements UserDetailsService{

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        User user = userMapper.getUserAccount(loginId);
        if(user == null)     throw new UsernameNotFoundException("Not Found User");
        return user;
    }

}