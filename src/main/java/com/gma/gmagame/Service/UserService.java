package com.gma.gmagame.Service;
import com.gma.gmagame.mapper.UserMapper;
import com.gma.gmagame.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Transactional
    public void joinUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setUser_pwd(passwordEncoder.encode(user.getUser_pwd()));
        //user.setUserAuth("N");
        //user.setCreate_date(localTime);
        //user.setAdmin_yn("Y");
        userMapper.saveUser(user);

    }
    @Override
    public User loadUserByUsername(String user_id) throws UsernameNotFoundException {
        //여기서 받은 유저 패스워드와 비교하여 로그인 인증
        User user = userMapper.getUserAccount(user_id);
        if (user == null){
            throw new UsernameNotFoundException("User not authorized.");
        }
        return user;
    }
    public User getMypage(String user_id) {
        return userMapper.getMypage(user_id);
    }

    public void UserUpdate(User user) {
        userMapper.updateUser(user);
    }
}
