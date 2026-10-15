package com.example.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final String USERNAME = "admin";
    private final String PASSWORD = "password123";

    @PostMapping("/login-static")
    public ResponseEntity<String> login(
            @RequestBody LoginRequest request) {

        if (USERNAME.equals(request.getUsername())
                && PASSWORD.equals(request.getPassword())) {

            return ResponseEntity.ok(
                    "Authentication Successful");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Authentication Failed");
    }
}