package com.example.inventory.dto;

import java.math.BigDecimal;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductDTO {

    private Long id;

    @NotBlank(message = "Product name is required")
    private String name;

    @Min(value = 0, message = "Quantity must be a positive number")
    private Integer quantity;

    @Positive(message = "Price must be a positive number")
    private BigDecimal price;

    @Valid
    private SupplierDTO supplier;

}
