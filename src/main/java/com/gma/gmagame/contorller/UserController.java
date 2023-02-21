package com.gma.gmagame.contorller;

import com.gma.gmagame.Service.UserService;
import com.gma.gmagame.mapper.UserMapper;
import com.gma.gmagame.model.User;
import lombok.RequiredArgsConstructor;
import oracle.ucp.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;


    @GetMapping("/register")
    public String register()
    {
        return "register";
    }

    @PostMapping("/register")
    public String register_info(User user) {
        /*
        this.userService.saveUser(user);

        ModelMap map = new ModelMap();
        map.put("user_no", user.getUser_no());
        return map;
        */
        userService.joinUser(user);
        return "redirect:/index";


    }
}
