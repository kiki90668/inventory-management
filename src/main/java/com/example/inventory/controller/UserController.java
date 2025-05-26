package com.example.inventory.controller;


import org.springframework.web.bind.annotation.*;

import com.example.inventory.dto.AuthRequest;
import com.example.inventory.model.ApiResponse;
import com.example.inventory.model.User;
import com.example.inventory.service.JwtService;
import com.example.inventory.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ApiResponse<String> register(@RequestBody AuthRequest authRequest) {
        userService.register(authRequest.getUsername(), authRequest.getPassword(), "ROLE_USER");
        return new ApiResponse<>("success", "User registered successfully", authRequest.getUsername());
    }

    @PostMapping("/login")
    public ApiResponse<String> login(@RequestBody AuthRequest authRequest) {
        User user = userService.login(authRequest.getUsername(), authRequest.getPassword());
        String token = jwtService.generateToken(user.getUsername());
        return new ApiResponse<>("success", "User logged in successfully", token);
    }
}
