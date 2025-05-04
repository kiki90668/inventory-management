package com.example.inventory.dto;

import java.util.List;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class SupplierProductsDTO {

    @Valid
    private SupplierDTO supplier;

    @Valid
    private List<ProductDTO> products;
}
