package com.example.inventory.service;

import org.springframework.stereotype.Service;

import com.example.inventory.model.User;
import com.example.inventory.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    // This method is used to register a new user
    public User register(String username, String rawPassword, String role) {
       String encodedPassword = passwordEncoder.encode(rawPassword);
       User user = User.builder()
               .username(username)
               .password(encodedPassword)
               .role(role)
               .build();
       return userRepository.save(user);
    }

    // This method is used to login a user
    public User login(String username, String rawPassword) {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found"));
        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new RuntimeException("Wrong password");
        }
        return user;
    }

}
