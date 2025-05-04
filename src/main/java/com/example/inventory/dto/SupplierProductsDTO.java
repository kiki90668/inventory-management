package com.example.inventory.dto;

import java.util.List;

import lombok.Data;

@Data
public class SupplierProductsDTO {
    private SupplierDTO supplier;
    private List<ProductDTO> products;
}
