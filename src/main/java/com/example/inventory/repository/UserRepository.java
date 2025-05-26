package com.example.inventory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventory.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
// Custom query methods can be defined here if needed
    Optional<User> findByUsername(String username);   
}
