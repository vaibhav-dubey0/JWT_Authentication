package com.example.jwt_authentication.Controller;

import java.util.List;
 import com.example.jwt_authentication.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt_authentication.Service.UserService;

@RestController
public class HomeController {
     
    @Autowired
    private UserService userService;

    
    @GetMapping("/user")
    public List<User> getUser(){
        
        return userService.getUsers();
    }
    
}
