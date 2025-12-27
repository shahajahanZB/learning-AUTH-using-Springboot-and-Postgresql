package com.example.authdemo.controller;

import com.example.authdemo.dto.LoginRequest;
import com.example.authdemo.dto.SignupRequest;
import com.example.authdemo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public String signup(@Valid @RequestBody SignupRequest request) {

        userService.register(
                request.getUsername(),
                request.getEmail(),
                request.getPassword()
        );

        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest request) {

        boolean success = userService.login(
                request.getUsername(),
                request.getPassword()
        );

        return success ? "Login successful" : "Invalid credentials";
    }
}
