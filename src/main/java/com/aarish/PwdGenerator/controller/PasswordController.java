package com.aarish.PwdGenerator.controller;

import com.aarish.PwdGenerator.DTO.PasswordRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.aarish.PwdGenerator.service.PasswordService;

@RestController
@RequestMapping("/api/password")
@CrossOrigin(origins = {
        "https://password-generator-backend-production-0581.up.railway.app",
        "http://localhost:3000"
})
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @PostMapping("/generate")
    public String generatePassword( @Valid  @RequestBody PasswordRequest request){
        return passwordService.generatePassword(request.getStrength(), request.getLength());
    }
}
