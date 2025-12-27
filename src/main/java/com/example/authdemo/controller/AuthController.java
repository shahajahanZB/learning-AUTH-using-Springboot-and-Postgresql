package com.example.authdemo.controller;

import com.example.authdemo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public String signup(@RequestBody Map<String, String> request) {

        userService.register(
                request.get("username"),
                request.get("email"),
                request.get("password")
        );

        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> request) {

        boolean success = userService.login(
                request.get("username"),
                request.get("password")
        );

        return success ? "Login successful" : "Invalid credentials";
    }
}
