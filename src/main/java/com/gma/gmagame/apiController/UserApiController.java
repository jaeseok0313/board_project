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

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userid}")
    public User getUserByUserId(@PathVariable String userid) {
        return userService.getUserAccount(userid);
    }

    @PostMapping("")
    public void registerUser(@RequestBody User user) {

        userService.registerUser(user);
    }

    @PutMapping("/{user_id}")
    public void modifyUser(@PathVariable String user_id, @RequestBody User user) {

        userService.modifyUser(user_id, user);
    }

    @DeleteMapping("/{userid}")
    public void removeUser(@PathVariable String userid) {
        userService.removeUser(userid);
    }
}
