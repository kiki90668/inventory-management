package com.example.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.inventory.dto.ProductDTO;
import com.example.inventory.mapper.ProductMapper;
import com.example.inventory.model.ApiResponse;
import com.example.inventory.model.Product;
import com.example.inventory.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Define endpoints for CRUD operations


    @GetMapping("/{id}")
    public ApiResponse<ProductDTO> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        ProductDTO productDTO = ProductMapper.toDTO(product);
        return new ApiResponse<>("success", "Product found", productDTO);
    }

    @GetMapping
    public ApiResponse<List<ProductDTO>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductDTO> productDTOs = ProductMapper.toDTOList(products);
        return new ApiResponse<>("success", "Products retrieved", productDTOs);
    }

    @PostMapping
    public ApiResponse<ProductDTO> addProduct(@Valid @RequestBody ProductDTO productDTO) {
        Product Product =  ProductMapper.toEntity(productDTO);
        Product savedProduct = productService.addProduct(Product);
        ProductDTO saveProductDTO = ProductMapper.toDTO(savedProduct); 
        return new ApiResponse<>("success", "Product successfully added", saveProductDTO);
    }

    @PostMapping("/addList")
    public ApiResponse<List<ProductDTO>> addProducts(@Valid @RequestBody List<ProductDTO> productDTOs) {
        List<Product> products = ProductMapper.toEntityList(productDTOs);
        List<Product> savedProducts = productService.addProducts(products);
        List<ProductDTO> savedProductDTOs = ProductMapper.toDTOList(savedProducts); 
        return new ApiResponse<>("success", "Products successfully added", savedProductDTOs);
    }

    @PutMapping("/{id}/ship/{quantity}")
    public ApiResponse<ProductDTO> shipProduct(@PathVariable Long id, @PathVariable Integer quantity) {
        Product updatedProduct = productService.shipProduct(id, quantity);
        ProductDTO productDTO = ProductMapper.toDTO(updatedProduct);
        return new ApiResponse<>("success", "Product shipped successfully", productDTO);
    }

    @PutMapping("/{id}")
    public ApiResponse<ProductDTO> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO) {
        Product product = ProductMapper.toEntity(productDTO);
        Product updatedProduct = productService.updateProduct(id, product);
        ProductDTO updatedProductDTO = ProductMapper.toDTO(updatedProduct);
        return new ApiResponse<>("success", "Product updated successfully", updatedProductDTO);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ApiResponse<>("success", "Product deleted successfully", null);
    }

}
