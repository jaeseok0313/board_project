package com.gma.gmagame.Service;

import com.gma.gmagame.mapper.UserMapper;
import com.gma.gmagame.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    Date localTime = time;

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectList() {
        return userMapper.selectList();
    }


    @Transactional
    @Override
    public void saveUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setUser_pwd(passwordEncoder.encode(user.getUser_pwd()));
        //user.setUserAuth("N");
        user.setCreate_date(localTime);
        user.setAdmin_yn("Y");

        userMapper.saveUser(user);

    }



}
