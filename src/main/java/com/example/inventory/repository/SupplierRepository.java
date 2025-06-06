package com.example.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventory.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    // Custom query methods can be defined here if needed

}
