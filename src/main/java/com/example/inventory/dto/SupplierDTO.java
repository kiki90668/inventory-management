package com.example.inventory.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class SupplierDTO {

    
    private Long id;

    @NotBlank(message = "Supplier name is required")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Contact number is required")
    private String contact;
}

