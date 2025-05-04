package com.example.inventory.mapper;

import java.util.List;

import com.example.inventory.dto.SupplierDTO;
import com.example.inventory.model.Supplier;

public class SupplierMapper {

    public static SupplierDTO toDTO(Supplier supplier) {
        if (supplier == null) {
            return null;
        }
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setId(supplier.getId());
        supplierDTO.setName(supplier.getName());
        supplierDTO.setEmail(supplier.getEmail());
        supplierDTO.setContact(supplier.getContact());
        return supplierDTO;
    }

    public static Supplier toEntity(SupplierDTO supplierDTO) {
        if (supplierDTO == null) {
            return null;
        }
        Supplier supplier = new Supplier();
        supplier.setId(supplierDTO.getId());
        supplier.setName(supplierDTO.getName());
        supplier.setEmail(supplierDTO.getEmail());
        supplier.setContact(supplierDTO.getContact());
        return supplier;
    }

    public static List<SupplierDTO> toDTOList(List<Supplier> suppliers) {
        if (suppliers == null || suppliers.isEmpty()) {
            return null;
        }
        return suppliers.stream().map(SupplierMapper::toDTO).toList();
    }

    public  static List<Supplier> toEntityList(List<SupplierDTO> supplierDTOs) {
        if (supplierDTOs == null || supplierDTOs.isEmpty()) {
            return null;
        }
        return supplierDTOs.stream().map(SupplierMapper::toEntity).toList();
    }
}
