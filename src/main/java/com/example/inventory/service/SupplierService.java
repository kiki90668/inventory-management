package com.example.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory.model.Supplier;
import com.example.inventory.repository.SupplierRepository;

@Service
public class SupplierService {

    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    // This method is used to get a supplier by ID
    public Supplier getSupplierById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Supplier ID cannot be null");
        }
        return supplierRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Supplier not found"));
    }

    // This method is used to get all suppliers
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    // This method is used to add a new supplier
    public Supplier addSupplier(Supplier supplier) {
        if (supplier.getId() != null) {
            throw new IllegalArgumentException("Supplier ID should not be provided for new suppliers");
        }
        return supplierRepository.save(supplier);
    }

    // This method is used to add multiple suppliers at once
    public List<Supplier> addSuppliers(List<Supplier> suppliers) {
        if (suppliers == null || suppliers.isEmpty()) {
            throw new IllegalArgumentException("Supplier list cannot be empty");
        }
        return supplierRepository.saveAll(suppliers);
    }

    // This method is used to update an existing supplier
    public Supplier updateSupplier(Long id, Supplier supplier) {
        if (id == null) {
            throw new IllegalArgumentException("Supplier ID cannot be null");
        }
        Supplier existingSupplier = supplierRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Supplier not found"));
        existingSupplier.setName(supplier.getName());
        existingSupplier.setContact(supplier.getContact());
        existingSupplier.setEmail(supplier.getEmail());
        return supplierRepository.save(existingSupplier);
    }

    public void deleteSupplier(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Supplier ID cannot be null");
        }
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Supplier not found"));
        supplierRepository.delete(supplier);
    }

}
