package com.example.inventory.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductDTO {

    private Long id;
    private String name;
    private Integer quantity;
    private BigDecimal price;
    private SupplierDTO supplier;

}
