package com.gma.gmagame.contorller;

import com.gma.gmagame.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
    @GetMapping("/login")
    public String login() {
        return "account/login";
    }

    @GetMapping("/register")
    public String register() {

        return "account/register";
    }
    @GetMapping("/asset_denied")
    public String accessDenied() {
        return "account/asset_denied";
    }
    @GetMapping("/user_access")
    public String userAccess(Model model, Authentication authentication) {
        //Authentication 객체를 통해 유저 정보를 가져올 수 있다.
        User user = (User) authentication.getPrincipal();  //userDetail 객체를 가져옴
        model.addAttribute("info", user.getUser_id() +"의 "+ user.getUsername()+ "님");      //유저 아이디
        return "account/user_access";
    }

}
