package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/logout")
public class LogoutController {

    @PostMapping
    public String logoutUser() {
        // Perform logout logic here
        // Example: Invalidate session, clear authentication, etc.
        return "Logout successful!";
    }
}
