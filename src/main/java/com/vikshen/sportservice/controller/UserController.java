package com.vikshen.sportservice.controller;

import com.vikshen.sportservice.entity.User;
import com.vikshen.sportservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public User getUser(@RequestParam("username") String username, @RequestParam("password") String password){
        return userService.authorization(username, password);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody @Valid User user){
        return userService.addUser(user);
    }

}
