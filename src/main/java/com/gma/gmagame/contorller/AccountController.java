package com.gma.gmagame.contorller;

import com.gma.gmagame.Service.UserService;
import com.gma.gmagame.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

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
    public String register(User user) {
        return "account/register";
    }
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register_info(@Valid User user, Errors errors, @RequestParam(name="user_id")String name,Model model) throws Exception {
        int result = userService.idCheck(user,name);
        if(errors.hasErrors()) {
            model.addAttribute("user",user);
            Map<String, String> validatorResult = userService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }
            return "account/register";
        }
        if(result==1)
        {
            return "account/register";
        }
        else {
            userService.registerUser(user);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "mypage", method = RequestMethod.GET)
    public String mypage(Principal principal, Model model){
        User user = userService.getMypage(principal.getName());
        model.addAttribute("user", user);
        return "account/mypage";
    }

    @RequestMapping(value = "mypage", method = RequestMethod.POST)
    public String updateUser(Principal principal, @ModelAttribute User user) {
        userService.UserUpdate(user);
        return "redirect:/";
    }
    @ResponseBody
    @RequestMapping(value = "/idCheck",method = RequestMethod.POST)
    public int idCheck(User user,@RequestParam(name = "user_id")String name) throws Exception{
        int result = userService.idCheck(user,name);
        System.out.println(result);
        return result;
    }

}
// this.userService.saveUser(user);
//
//         ModelMap map = new ModelMap();
//         map.put("user_no", user.getUser_no());
//         return map;
//         */