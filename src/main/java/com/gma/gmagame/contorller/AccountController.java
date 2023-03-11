package com.gma.gmagame.contorller;

import com.gma.gmagame.Service.UserService;
import com.gma.gmagame.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final UserService userService;
    @RequestMapping(value = "login")
    public String login() {
        return "account/login";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "account/register";
    }
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register_info(User user) {

        userService.registerUser(user);
        return "redirect:/";
    }
    @GetMapping("/mypage")
    //@RequestMapping(value = "mypage", method = RequestMethod.GET)
    public String mypage(Principal principal, Model model){

        User user = userService.getMypage(principal.getName());
        model.addAttribute("user", user);
        System.out.println(user);
        System.out.println(model);
        return "account/mypage";
    }

    @PostMapping("/mypage")
    public String updateUser(Principal principal, @ModelAttribute User user) {
        userService.UserUpdate(user);
        return "redirect:/";
    }

}
// this.userService.saveUser(user);
//
//         ModelMap map = new ModelMap();
//         map.put("user_no", user.getUser_no());
//         return map;
//         */