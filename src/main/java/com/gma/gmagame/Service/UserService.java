package com.gma.gmagame.Service;
import com.gma.gmagame.mapper.UserMapper;
import com.gma.gmagame.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    //모든 유저정보 조회
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    //유저 정보 조회
    @Override
    public User loadUserByUsername(String user_id) throws UsernameNotFoundException {
        //여기서 받은 유저 패스워드와 비교하여 로그인 인증
        User user = userMapper.getUserAccount(user_id);
        if (user == null) {
            throw new UsernameNotFoundException("User not authorized.");
        }
        return user;
    }

    //유저 회원가입
    public void registerUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setUser_pwd(passwordEncoder.encode(user.getUser_pwd()));
        userMapper.registerUser(user);
    }

    //유저정보 수정
    public void modifyUser(String Id, User user) {
        user.setId(Id);
        userMapper.userUpdate(user);
    }

    //유저정보 삭제
    public void removeUser(String userId) {
        userMapper.deleteUser(userId);
    }

    public User getMypage(String user_id) {
        return userMapper.getMypage(user_id);
    }

    public void UserUpdate(User user) {
        userMapper.updateUser(user);
    }
    public int idCheck(User user,String name) throws Exception{
        user.setUser_id(name);
        int result = userMapper.idChk(user);
        return result;
    }
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }
    public void passChange(User user,String userId,String userPw)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setUser_id(userId);
        user.setUser_pwd(passwordEncoder.encode(userPw));
        userMapper.passChange(user);
    }

}


