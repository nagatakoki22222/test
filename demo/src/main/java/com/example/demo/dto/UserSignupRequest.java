package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserSignupRequest {

    @NotBlank(message = "User updation failed")
    @Size(min = 6, max = 20, message = "User updation failed")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "User updation failed")
    private String userId;

    @NotBlank(message = "User updation failed")
    @Size(min = 8, max = 20, message = "User updation failed")
    @Pattern(regexp = "^[ -~]+$", message = "User updation failed")
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}