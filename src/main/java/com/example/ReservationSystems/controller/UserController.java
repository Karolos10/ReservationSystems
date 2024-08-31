package com.example.ReservationSystems.controller;

import com.example.ReservationSystems.model.User;
import com.example.ReservationSystems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) throws Exception {
        return userService.saveUser(user);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) throws Exception {
        return userService.getUser(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer userId){
        userService.deleteUser(userId);
    }
}
