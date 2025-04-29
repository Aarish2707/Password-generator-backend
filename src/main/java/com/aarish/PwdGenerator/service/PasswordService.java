package com.aarish.PwdGenerator.service;

import org.springframework.stereotype.Service;
import com.aarish.PwdGenerator.utility.PasswordUtility;

@Service
public class PasswordService {

    public String generatePassword(String strength, int length){
        return PasswordUtility.generatePassword(strength, length);
    }
}
