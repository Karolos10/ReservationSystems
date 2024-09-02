package com.example.ReservationSystems.controller;

import com.example.ReservationSystems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer userId){
        userService.deleteUser(userId);
    }
}
