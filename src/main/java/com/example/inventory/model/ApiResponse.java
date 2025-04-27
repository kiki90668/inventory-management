package com.example.inventory.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private String status; // "success" or "error"
    private String message;
    private T data;
}


