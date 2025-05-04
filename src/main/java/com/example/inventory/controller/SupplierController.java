package com.example.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.inventory.model.ApiResponse;
import com.example.inventory.model.Supplier;
import com.example.inventory.service.SupplierService;


@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    private SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/{id}")
    public ApiResponse<Supplier> getSupplierById(@PathVariable Long id) {
        Supplier supplier = supplierService.getSupplierById(id);
        return new ApiResponse<>("success", "Supplier found", supplier);
    }

    @GetMapping
    public ApiResponse<List<Supplier>> getAllSuppliers() {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        return new ApiResponse<>("success", "Suppliers retrieved", suppliers);
 
    }

     @PostMapping
    public ApiResponse<Supplier> addSupplier(@RequestBody Supplier supplier) {
        Supplier saveSupplier =  supplierService.addSupplier(supplier);
        return new ApiResponse<>("success", "Supplier successfully added", saveSupplier);
    }

    @PostMapping("/addList")
    public ApiResponse<List<Supplier>> addSuppliers(@RequestBody List<Supplier> suppliers) {
        List<Supplier> saveSuppliers = supplierService.addSuppliers(suppliers);
        return new ApiResponse<>("success", "Suppliers successfully added", saveSuppliers);
    }


    @PutMapping("/{id}")
    public ApiResponse<Supplier> updateSupplier (@PathVariable Long id, @RequestBody Supplier supplier) {
        Supplier updatedSupplier = supplierService.updateSupplier(id, supplier);
        return new ApiResponse<>("success", "Supplier updated successfully", updatedSupplier);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return new ApiResponse<>("success", "Supplier deleted successfully", null);
    }


}
