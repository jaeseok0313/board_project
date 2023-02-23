package com.gma.gmagame.contorller;

import com.gma.gmagame.Service.UserService;
import com.gma.gmagame.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final UserService userService;


    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "account/login";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {

        return "account/register";
    }
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register_info(User user) {


        userService.joinUser(user);
        return "redirect:/";
    }



}
// this.userService.saveUser(user);
//
//         ModelMap map = new ModelMap();
//         map.put("user_no", user.getUser_no());
//         return map;
//         */