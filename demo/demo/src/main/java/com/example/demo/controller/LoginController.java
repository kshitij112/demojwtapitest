package com.example.demo.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;

@RestController
public class LoginController {

    @Value("${jwt.secret}") // Add this line to read the JWT secret from application.properties
    private String jwtSecret;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        // Simulated login logic
        if (user.getUsername() != null && user.getPassword() != null) {
            if (user.getUsername().equals("admin") && user.getPassword().equals("password")) {
                // Generate JWT token
                String token = Jwts.builder()
                        .setSubject(user.getUsername())
                        .signWith(SignatureAlgorithm.HS512, jwtSecret.getBytes())
                        .compact();

                return "Login successful. JWT token: " + token;
            } else {
                return "Invalid username or password";
            }
        } else {
            return "Invalid input";
        }
    }
}
