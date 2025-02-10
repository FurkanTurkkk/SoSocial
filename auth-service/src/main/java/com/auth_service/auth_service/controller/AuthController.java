package com.auth_service.auth_service.controller;

import com.auth_service.auth_service.dto.LoginRequestDto;
import com.auth_service.auth_service.dto.RegisterRequestDto;
import com.auth_service.auth_service.model.Auth;
import com.auth_service.auth_service.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/auth")
@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDto request){
        ResponseEntity.ok(authService.register(request));
        return ResponseEntity.ok("Registration successful...");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto request){
        return ResponseEntity.ok(authService.login(request));
    }
}
