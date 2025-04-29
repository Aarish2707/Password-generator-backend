package com.aarish.PwdGenerator.DTO;

import jakarta.validation.constraints.*;


public class PasswordRequest {

    @NotBlank(message = "Strength is required")
    private String strength;

    @Min(value = 4, message = "Minimum password length is 4")
    @Max(value = 128, message = "Maximum password length is 128")
    private int length;


    //getters and setters for strength and length
    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    //toString

    @Override
    public String toString() {
        return "PasswordRequest{" +
                "strength='" + strength + '\'' +
                ", length=" + length +
                '}';
    }
}
