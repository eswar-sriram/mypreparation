package com.project.mypreparation.controller;

import com.project.mypreparation.model.UserData;
import com.project.mypreparation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/validateuser")
    public Object isUserThere(@RequestBody UserData userData){
        return userService.isUserThere(userData);
    }

    @PostMapping("/adduser")
    public Object addUser(@RequestBody UserData user){
        return userService.addUser(user);
    }

}
