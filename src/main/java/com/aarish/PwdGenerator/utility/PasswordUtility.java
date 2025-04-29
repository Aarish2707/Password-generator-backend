package com.aarish.PwdGenerator.utility;

import org.springframework.beans.factory.annotation.Autowired;

import java.security.SecureRandom;

public class PasswordUtility {

    //Strings for matching the characters
    private static final String LowerCase = "abcdefghijklmnopqrstuvwxyz";
    private static final String UpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String numbers = "0123456789";
    private static final String SpecialChars = "!@#$%^&*()-_+=[]{}|<>?,.;'/~";

    private static final SecureRandom random = new SecureRandom();

    public static String generatePassword(String strength, int length){
        String charPool = switch (strength.toUpperCase()) {
            case "LOW" -> LowerCase + UpperCase;
            case "MEDIUM" -> LowerCase + UpperCase + numbers;
            case "HIGH" -> LowerCase + UpperCase + numbers + SpecialChars;
            default -> throw new IllegalArgumentException("Invalid Strength level: " + strength);
        };

        if ( length <= 0){
            throw new IllegalArgumentException("Length of password must be greater than zero!!");
        }

        StringBuilder password = new StringBuilder(length);
        for (int i=0;i<length;i++){
            int index = random.nextInt(charPool.length());
            password.append(charPool.charAt(index));
        }
        return password.toString();
    }

}
