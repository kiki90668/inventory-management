package com.example.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.inventory.model.ApiResponse;
import com.example.inventory.model.Product;
import com.example.inventory.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Define endpoints for CRUD operations


    @GetMapping("/{id}")
    public ApiResponse<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return new ApiResponse<>("success", "Product found", product);
    }

    @GetMapping
    public ApiResponse<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ApiResponse<>("success", "Products retrieved", products);
    }

    @PostMapping
    public ApiResponse<Product> addProduct(@RequestBody Product product) {
        Product saveProduct =  productService.addProduct(product);
        return new ApiResponse<>("success", "Product successfully added", saveProduct);
    }

    @PostMapping("/addList")
    public ApiResponse<List<Product>> addProducts(@RequestBody List<Product> products) {
        List<Product> saveProducts = productService.addProducts(products);
        return new ApiResponse<>("success", "Products successfully added", saveProducts);
    }

    @PutMapping("/{id}/ship/{quantity}")
    public ApiResponse<Product> shipProduct(@PathVariable Long id, @PathVariable Integer quantity) {
        Product updatedProduct = productService.shipProduct(id, quantity);
        return new ApiResponse<Product>("success", "Product shipped successfully", updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ApiResponse<>("success", "Product deleted successfully", null);
    }

}
