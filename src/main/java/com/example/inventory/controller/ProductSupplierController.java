package com.example.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.inventory.model.ApiResponse;
import com.example.inventory.model.Product;
import com.example.inventory.model.Supplier;
import com.example.inventory.service.ProductSupplierService;

@RestController
@RequestMapping("/product-supplier")
public class ProductSupplierController {

    private ProductSupplierService productSupplierService;
    
    @Autowired
    public ProductSupplierController(ProductSupplierService productSupplierService) {
        this.productSupplierService = productSupplierService;
    }

    @PostMapping
    public ApiResponse<Supplier> addSupplierWithProduct(@RequestBody Supplier supplier, @RequestBody Product product) {
        Supplier savedSupplier = productSupplierService.addSupplierWithProduct(supplier, product);
        return new ApiResponse<>("success", "Supplier with product added successfully", savedSupplier);
    }


    @PostMapping("/addList")
    public ApiResponse<Supplier> addSupplierWithProducts(@RequestBody Supplier supplier, @RequestBody List<Product> products) {
        Supplier savedSupplier = productSupplierService.addSupplierWithProducts(supplier, products);
        return new ApiResponse<>("success", "Supplier with products added successfully", savedSupplier);
    }
}
