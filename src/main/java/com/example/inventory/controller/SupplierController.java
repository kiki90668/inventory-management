package com.example.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.inventory.dto.SupplierDTO;
import com.example.inventory.mapper.SupplierMapper;
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
    public ApiResponse<SupplierDTO> getSupplierById(@PathVariable Long id) {
        Supplier supplier = supplierService.getSupplierById(id);
        SupplierDTO supplierDTO = SupplierMapper.toDTO(supplier);
        return new ApiResponse<>("success", "Supplier found", supplierDTO);
    }

    @GetMapping
    public ApiResponse<List<SupplierDTO>> getAllSuppliers() {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        List<SupplierDTO> supplierDTOs = SupplierMapper.toDTOList(suppliers);
        return new ApiResponse<>("success", "Suppliers retrieved", supplierDTOs);
 
    }

     @PostMapping
    public ApiResponse<SupplierDTO> addSupplier(@RequestBody SupplierDTO supplierDTO) {
        Supplier supplier = SupplierMapper.toEntity(supplierDTO);
        Supplier saveSupplier =  supplierService.addSupplier(supplier);
        SupplierDTO saveSupplierDTO = SupplierMapper.toDTO(saveSupplier);
        return new ApiResponse<>("success", "Supplier successfully added", saveSupplierDTO);
    }

    @PostMapping("/addList")
    public ApiResponse<List<SupplierDTO>> addSuppliers(@RequestBody List<SupplierDTO> supplierDTOs) {
        List<Supplier> suppliers = SupplierMapper.toEntityList(supplierDTOs);
        List<Supplier> saveSuppliers = supplierService.addSuppliers(suppliers);
        List<SupplierDTO> saveSupplierDTOs = SupplierMapper.toDTOList(saveSuppliers);
        return new ApiResponse<>("success", "Suppliers successfully added", saveSupplierDTOs);
    }


    @PutMapping("/{id}")
    public ApiResponse<SupplierDTO> updateSupplier (@PathVariable Long id, @RequestBody SupplierDTO supplierDTO) {
        Supplier supplier = SupplierMapper.toEntity(supplierDTO);
        Supplier updatedSupplier = supplierService.updateSupplier(id, supplier);
        SupplierDTO updatedSupplierDTO = SupplierMapper.toDTO(updatedSupplier);
        return new ApiResponse<>("success", "Supplier updated successfully", updatedSupplierDTO);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return new ApiResponse<>("success", "Supplier deleted successfully", null);
    }


}
