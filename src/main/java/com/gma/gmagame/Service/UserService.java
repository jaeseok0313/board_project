package com.gma.gmagame.Service;
import com.gma.gmagame.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> selectList();

    public void saveUser(User user);



}
