package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return authService.registerUser(user);
    }

    @PostMapping("login")
    public ResponseEntity<User> login(@RequestBody User user) {
        return authService.loginUser(user);
    }
}
