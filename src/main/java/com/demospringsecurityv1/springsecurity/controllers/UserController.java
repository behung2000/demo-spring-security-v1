package com.demospringsecurityv1.springsecurity.controllers;

import com.demospringsecurityv1.springsecurity.requests.UserInfo;
import com.demospringsecurityv1.springsecurity.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spring-security/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public List<UserInfo> getAll() {
        return userService.getAll();
    }
}
