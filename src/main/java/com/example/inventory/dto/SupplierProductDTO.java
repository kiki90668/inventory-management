package com.example.inventory.dto;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class SupplierProductDTO {

    @Valid
    private SupplierDTO supplier;

    @Valid
    private ProductDTO product;
}
