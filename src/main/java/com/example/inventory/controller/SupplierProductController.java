package com.example.inventory.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.inventory.dto.ProductDTO;
import com.example.inventory.dto.SupplierProductDTO;
import com.example.inventory.dto.SupplierProductsDTO;
import com.example.inventory.mapper.ProductMapper;
import com.example.inventory.mapper.SupplierMapper;
import com.example.inventory.model.ApiResponse;
import com.example.inventory.model.Product;
import com.example.inventory.model.Supplier;
import com.example.inventory.service.SupplierProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/supplier-product")
@RequiredArgsConstructor
public class SupplierProductController {

    private final SupplierProductService supplierProductService;


    @PostMapping("/add")
    public ApiResponse<SupplierProductDTO> addSupplierWithProduct(@Valid @RequestBody SupplierProductDTO supplierProductDTO) {
        Supplier supplier = SupplierMapper.toEntity(supplierProductDTO.getSupplier());
        Product product = ProductMapper.toEntity(supplierProductDTO.getProduct());
        Supplier savedSupplier = supplierProductService.addSupplierWithProduct(supplier, product);
        SupplierProductDTO responseDTO = new SupplierProductDTO();
        responseDTO.setSupplier(SupplierMapper.toDTO(savedSupplier));
        responseDTO.setProduct(ProductMapper.toDTO(product));
        return new ApiResponse<>("success", "Supplier with product added successfully", responseDTO);
    }

    @PostMapping("/addList")
    public ApiResponse<SupplierProductsDTO> addSupplierWithProducts(@Valid @RequestBody SupplierProductsDTO supplierProductsDTO) {
        Supplier supplier = SupplierMapper.toEntity(supplierProductsDTO.getSupplier());
        List<Product> products = ProductMapper.toEntityList(supplierProductsDTO.getProducts());
        Supplier savedSupplier = supplierProductService.addSupplierWithProducts(supplier, products);
        SupplierProductsDTO responseDTO = new SupplierProductsDTO();
        responseDTO.setSupplier(SupplierMapper.toDTO(savedSupplier));
        responseDTO.setProducts(ProductMapper.toDTOList(products));
        return new ApiResponse<>("success", "Supplier with products added successfully", responseDTO);
    }

    @GetMapping("/{supplierId}/products")
    public ApiResponse<List<ProductDTO>> getProductsWithSupplier (@Valid @PathVariable Long supplierId) {
        List<Product> products = supplierProductService.getProductsBySupplierId(supplierId);
        List<ProductDTO> productDTOs = products.stream().map(ProductMapper::toDTO).toList();
        return new ApiResponse<>("success", "Products retrieved successfully", productDTOs);
    }

    @GetMapping("/all")
    public ApiResponse<List<SupplierProductsDTO>> getAllSupplierProducts () {
        HashMap<Supplier, List<Product>> supplierProductsMap = supplierProductService.getAllSupplierProducts();
        List<SupplierProductsDTO> supplierProductsDTO = supplierProductsMap.entrySet().stream()
        .map(entry -> {
            SupplierProductsDTO dto = new SupplierProductsDTO();
            dto.setSupplier(SupplierMapper.toDTO(entry.getKey()));
            dto.setProducts(ProductMapper.toDTOList(entry.getValue()));
            return dto;
        }).toList();
        return new ApiResponse<>("success", "All supplier products retrieved successfully", supplierProductsDTO);
    }


 }
