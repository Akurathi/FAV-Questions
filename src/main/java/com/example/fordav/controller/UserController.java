package com.example.fordav.controller;

import com.example.fordav.entity.UserInput;
import com.example.fordav.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ford")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping(value = "/add", produces = "application/json")
    public Long addUser(@RequestBody UserInput input){
        return service.addUser(input);
    }

}
