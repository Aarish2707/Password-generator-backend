package com.aarish.PwdGenerator.controller;

import com.aarish.PwdGenerator.DTO.PasswordRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.aarish.PwdGenerator.service.PasswordService;

@RestController
@RequestMapping("/api/password")
@CrossOrigin(origins = {
        "https://password-generate-zvep.onrender.com",
        "http://localhost:3000",
        "http://localhost:8080"
})
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @GetMapping("/test")
    public String test() {
        return "Backend is working!";
    }

    @PostMapping("/generate")
    public String generatePassword(@Valid @RequestBody PasswordRequest request) {
        try {
            return passwordService.generatePassword(request.getStrength(), request.getLength());
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate password: " + e.getMessage());
        }
    }
}
