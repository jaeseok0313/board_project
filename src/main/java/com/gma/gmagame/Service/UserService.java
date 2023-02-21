package com.gma.gmagame.Service;
import com.gma.gmagame.mapper.UserMapper;
import com.gma.gmagame.model.User;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Mapper
@RequiredArgsConstructor
public class UserService{
    @Autowired
    UserMapper userMapper;
    @Transactional
    public void joinUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setUser_pwd(passwordEncoder.encode(user.getUser_pwd()));
        //user.setUserAuth("N");
        //user.setCreate_date(localTime);
        //user.setAdmin_yn("Y");
        userMapper.saveUser(user);

    }





}
