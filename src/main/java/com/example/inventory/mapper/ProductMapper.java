package com.example.inventory.mapper;

import java.util.List;

import com.example.inventory.dto.ProductDTO;
import com.example.inventory.model.Product;

public class ProductMapper {

    public static ProductDTO toDTO (Product product) {
        if (product == null) {
            return null;
        }
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setPrice(product.getPrice());
        productDTO.setSupplier(SupplierMapper.toDTO(product.getSupplier()));
        return productDTO;
    }

    public static Product toEntity (ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setQuantity(productDTO.getQuantity());
        product.setPrice(productDTO.getPrice());
        product.setSupplier(SupplierMapper.toEntity(productDTO.getSupplier()));
        return product;
    }

    public static List<ProductDTO> toDTOList (List<Product> products) {
        if (products == null) {
            return null;
        }
        return products.stream().map(ProductMapper::toDTO).toList();
    }
    public static List<Product> toEntityList (List<ProductDTO> productDTOs) {
        if (productDTOs == null) {
            return null;
        }
        return productDTOs.stream().map(ProductMapper::toEntity).toList();
    }

}
