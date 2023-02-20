package com.gma.gmagame.contorller;

import com.gma.gmagame.mapper.UserMapper;
import com.gma.gmagame.model.User;
import lombok.RequiredArgsConstructor;
import oracle.ucp.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/main")
    public List<User> main()
    {
        List<User> list = userMapper.selectList();
        return list;
    }

    @GetMapping("/register")
    public String register()
    {
        return "register";
    }

    @PostMapping("/register")
    public String register_info(User user)
    {
        userMapper.saveUser(user);
        return "redirect:/index";
    }
}
