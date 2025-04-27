package com.example.inventory.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.inventory.model.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<String>> handleIllegalArugumentException(IllegalArgumentException ex) {
        ApiResponse<String> response = new ApiResponse<>("error", ex.getMessage(), null);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleGeneralException (Exception ex) {
        ApiResponse<String> response = new ApiResponse<>("error", ex.getMessage(), null);
        return ResponseEntity.internalServerError().body(response);
    }
    
}
