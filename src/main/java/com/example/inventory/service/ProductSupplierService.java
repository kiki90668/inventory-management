package com.example.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.inventory.model.Product;
import com.example.inventory.model.Supplier;
import com.example.inventory.repository.ProductRepository;
import com.example.inventory.repository.SupplierRepository;

@Service
public class ProductSupplierService {

    private ProductRepository productRepository;
    private SupplierRepository supplierRepository;

    @Autowired
    public ProductSupplierService(ProductRepository productRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    @Transactional
    public Supplier addSupplierWithProduct (Supplier supplier, Product product) {
        // Save the supplier first
        Supplier savedSupplier = supplierRepository.save(supplier);

        // Set the supplier to the product
        product.setSupplier(savedSupplier);
        productRepository.save(product);
        return savedSupplier;

    }

    @Transactional
    public Supplier addSupplierWithProducts (Supplier supplier, List<Product> products) {
        // Save the supplier first
        Supplier savedSupplier = supplierRepository.save(supplier);

        // Set the supplier to each product
        for (Product product : products) {
            product.setSupplier(savedSupplier);
        }
        productRepository.saveAll(products);
        return savedSupplier;
    }


}
