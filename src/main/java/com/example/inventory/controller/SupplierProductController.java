package com.example.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.inventory.dto.SupplierProductDTO;
import com.example.inventory.dto.SupplierProductsDTO;
import com.example.inventory.mapper.ProductMapper;
import com.example.inventory.mapper.SupplierMapper;
import com.example.inventory.model.ApiResponse;
import com.example.inventory.model.Product;
import com.example.inventory.model.Supplier;
import com.example.inventory.service.SupplierProductService;

@RestController
@RequestMapping("/product-supplier")
public class SupplierProductController {

    private SupplierProductService productSupplierService;
    
    @Autowired
    public SupplierProductController(SupplierProductService productSupplierService) {
        this.productSupplierService = productSupplierService;
    }

    @PostMapping
    public ApiResponse<SupplierProductDTO> addSupplierWithProduct(@RequestBody SupplierProductDTO supplierProductDTO) {
        Supplier supplier = SupplierMapper.toEntity(supplierProductDTO.getSupplier());
        Product product = ProductMapper.toEntity(supplierProductDTO.getProduct());
        Supplier savedSupplier = productSupplierService.addSupplierWithProduct(supplier, product);
        SupplierProductDTO responseDTO = new SupplierProductDTO();
        responseDTO.setSupplier(SupplierMapper.toDTO(savedSupplier));
        responseDTO.setProduct(ProductMapper.toDTO(product));
        return new ApiResponse<>("success", "Supplier with product added successfully", responseDTO);
    }

    @PostMapping("/addList")
    public ApiResponse<SupplierProductsDTO> addSupplierWithProducts(@RequestBody SupplierProductsDTO supplierProductsDTO) {
        Supplier supplier = SupplierMapper.toEntity(supplierProductsDTO.getSupplier());
        List<Product> products = ProductMapper.toEntityList(supplierProductsDTO.getProducts());
        Supplier savedSupplier = productSupplierService.addSupplierWithProducts(supplier, products);
        SupplierProductsDTO responseDTO = new SupplierProductsDTO();
        responseDTO.setSupplier(SupplierMapper.toDTO(savedSupplier));
        responseDTO.setProducts(ProductMapper.toDTOList(products));
        return new ApiResponse<>("success", "Supplier with products added successfully", responseDTO);
    }
}
