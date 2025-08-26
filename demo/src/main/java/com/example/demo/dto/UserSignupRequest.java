package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserSignupRequest {

    @NotBlank(message = "Required user_id and password")
    @Size(min = 6, max = 20, message = "Input length is incorrect")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Incorrect character pattern")
    private String userId;

    @NotBlank(message = "Required user_id and password")
    @Size(min = 8, max = 20, message = "Input length is incorrect")
    @Pattern(regexp = "^[ -~]+$", message = "Incorrect character pattern")
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