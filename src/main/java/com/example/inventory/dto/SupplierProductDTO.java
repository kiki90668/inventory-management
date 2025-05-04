package com.example.inventory.dto;

import lombok.Data;

@Data
public class SupplierProductDTO {
    private SupplierDTO supplier;
    private ProductDTO product;
}
