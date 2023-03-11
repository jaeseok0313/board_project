package com.gma.gmagame.apiController;

import com.gma.gmagame.Service.UserService;
import com.gma.gmagame.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @Autowired
    private UserService userService;
    //전체 유저 조회
    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    //유저 조회
    @GetMapping("/{userid}")
    public User getUserByUserId(@PathVariable String userid) {
        return userService.loadUserByUsername(userid);
    }
    //유저 회원가입
    @PostMapping("")
    public void registerUser(@RequestBody User user) {
        userService.registerUser(user);
    }
    //유저정보 수정
    @PutMapping("/{user_id}")
    public void modifyUser(@PathVariable String user_id, @RequestBody User user) {
        userService.modifyUser(user_id, user);
    }
    //유저정보 삭제
    @DeleteMapping("/{userid}")
    public void removeUser(@PathVariable String userid) {
        userService.removeUser(userid);
    }
}
