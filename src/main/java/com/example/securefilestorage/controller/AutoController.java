package com.example.securefilestorage.controller;

import com.example.securefilestorage.model.User;
import com.example.securefilestorage.repository.UserRepository;
import com.example.securefilestorage.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userRepository.save(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User foundUser = userRepository.findByUsername(user.getUsername()).orElseThrow();
        if (!foundUser.getPassword().equals(user.getPassword())) return "Invalid credentials";
        return jwtUtil.generateToken(user.getUsername());
    }
}
