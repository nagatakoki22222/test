package com.example.demo.controller;

import com.example.demo.dto.UserSignupRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class UserController {
    private static final Map<String, String> userDatabase = new ConcurrentHashMap<>();

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(@Valid @RequestBody UserSignupRequest request) {

        if (userDatabase.containsKey(request.getUserId())) {
            Map<String, String> errorBody = Map.of(
                    "message", "Account creation failed",
                    "cause", "Already same user_id is used");
            return new ResponseEntity<>(Collections.unmodifiableMap(errorBody), HttpStatus.BAD_REQUEST);
        }

        userDatabase.put(request.getUserId(), request.getPassword());

        Map<String, String> userMap = Map.of(
                "user_id", request.getUserId(),
                "nickname", request.getUserId());
        Map<String, Object> successBody = Map.of(
                "message", "Account successfully created",
                "user", userMap);

        return new ResponseEntity<>(successBody, HttpStatus.OK);
    }
}