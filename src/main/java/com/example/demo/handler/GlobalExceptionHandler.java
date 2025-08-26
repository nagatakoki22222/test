package com.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String cause = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();

        Map<String, String> errorBody = Map.of(
                "message", "Account creation failed",
                "cause", cause);

        return new ResponseEntity<>(Map.copyOf(errorBody), HttpStatus.BAD_REQUEST);
    }
}