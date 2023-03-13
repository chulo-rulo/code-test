package com.capgemini.blablacap.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.blablacap.models.User;
import com.capgemini.blablacap.services.UserService;

@RestController
@RequestMapping("/users")
public class UserREST {
    @Autowired
    private UserService userService;

    @GetMapping
    private ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }
    
}
