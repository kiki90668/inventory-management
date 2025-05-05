package com.example.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventory.model.Product;
import com.example.inventory.model.Supplier;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query methods can be defined here if needed
    // For example, findByName(String name) or findByPriceLessThan(Integer price)
    List<Product> findBySupplier (Supplier supplier);

}
