package com.example.inventory.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.inventory.model.Product;
import com.example.inventory.model.Supplier;
import com.example.inventory.repository.ProductRepository;
import com.example.inventory.repository.SupplierRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplierProductService {

    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;



    @Transactional
    public Supplier addSupplierWithProduct (Supplier supplier, Product product) {
        // Save the supplier first
        Supplier savedSupplier;

        if (supplier.getId() !=null) {
            // If the supplier already exists, fetch it from the database
            savedSupplier = supplierRepository.findById(supplier.getId()).orElseThrow(() -> new IllegalArgumentException("Supplier ID" + supplier.getId() + " not found"));
        } else {
            // If the supplier is new, save it
            savedSupplier = supplierRepository.save(supplier);
        }
        // Set the supplier to the product
        product.setSupplier(savedSupplier);
        productRepository.save(product);
        return savedSupplier;

    }

    @Transactional
    public Supplier addSupplierWithProducts (Supplier supplier, List<Product> products) {
        // Save the supplier first
        Supplier savedSupplier;

        if (supplier.getId() !=null) {
            // If the supplier already exists, fetch it from the database
            savedSupplier = supplierRepository.findById(supplier.getId())
            .orElseThrow(() -> new IllegalArgumentException("Supplier ID" + supplier.getId() + " not found"));
        } else {
            // If the supplier is new, save it
            savedSupplier = supplierRepository.save(supplier);
        }

        // Set the supplier to each product
        for (Product product : products) {
            product.setSupplier(savedSupplier);
        }
        productRepository.saveAll(products);
        return savedSupplier;
    }

    public List<Product> getProductsBySupplierId (Long supplierId) {
        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new IllegalArgumentException("Supplier ID" + supplierId + " not found"));
        
        return productRepository.findBySupplier(supplier);
    }

    public HashMap<Supplier, List<Product>> getAllSupplierProducts () {
        HashMap<Supplier, List<Product>> all = new HashMap<>();
        List<Supplier> suppliers = supplierRepository.findAll();
        for (Supplier supplier : suppliers) {
            List<Product> products = productRepository.findBySupplier(supplier);
            all.put(supplier, products);
        }
        return all;
    }


}
