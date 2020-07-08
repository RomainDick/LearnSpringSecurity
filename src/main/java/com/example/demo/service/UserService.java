package com.example.demo.service;

import com.example.demo.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUser(Long id);

    Optional<User> getUserByUsername(String username);

    User updateUser(User user);

    User createUser(User user);

    void deleteUser(User user);
}
