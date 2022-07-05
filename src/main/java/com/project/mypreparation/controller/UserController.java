package com.project.mypreparation.controller;


import com.project.mypreparation.model.GenericObject;
import com.project.mypreparation.model.UserData;
import com.project.mypreparation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
