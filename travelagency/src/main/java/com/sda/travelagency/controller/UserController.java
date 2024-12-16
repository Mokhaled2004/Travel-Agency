package com.sda.travelagency.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sda.travelagency.model.User;
import com.sda.travelagency.service.UserService;


@RestController
@RequestMapping("/UserController")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(user);
    }


}

    


