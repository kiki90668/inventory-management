package com.example.inventory.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.inventory.model.Product;
import com.example.inventory.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    
    private final ProductRepository productRepository;




    // Method to get a product by ID
    public Product getProductById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }


    //Method to get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Method to add a new product
    public Product addProduct(Product product) {
        if (product.getId() != null) {
            throw new IllegalArgumentException("Product ID should not be provided for new products");
        }
        return productRepository.save(product);
    }

    // Method to add a list of products
    public List<Product> addProducts(List<Product> products) {
        if (products != null && !products.isEmpty()) {
            return productRepository.saveAll(products);
        } else {
            throw new IllegalArgumentException("Product list cannot be empty");
        }
    }

    // Method to ship a product
    public Product shipProduct(Long id, Integer quantity) {
        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Invalid quantity");
        }

        Product product = productRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        if (product.getQuantity() >= quantity) {
            product.setQuantity(product.getQuantity() - quantity);
            return productRepository.save(product);
        } else {
            throw new IllegalArgumentException("Not enough stock available");
        }
    }

    // Method to update a product
    public Product updateProduct(Long id, Product product) {
        if (id == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return productRepository.save(existingProduct);
    }

    // Method to delete a product
    public void deleteProduct(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        productRepository.delete(product);
    }
}
