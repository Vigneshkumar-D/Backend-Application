package com.example.backendapplication.controller;

import com.example.backendapplication.model.User;
import com.example.backendapplication.service.UserH2Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class UserController{
    @Autowired
    public UserH2Service userH2Service;
    @PostMapping("/api/users/login")
    public String userLogin(@RequestBody User userDetails){
        return userH2Service.userLogin(userDetails);
    }
    @PostMapping("/api/users/signup")
    public User userSignup(@RequestBody User userDetails){
        return userH2Service.userSignup(userDetails);
    }
    @GetMapping("/api/users/")
    public String userHome(@RequestHeader("jwtToken") String jwtToken)
    {
        return userH2Service.userHome(jwtToken);
    }
}
