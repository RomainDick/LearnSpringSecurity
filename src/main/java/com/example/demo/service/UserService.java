package com.example.demo.service;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.exception.EmailExistsException;
import com.example.demo.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUser(Long id);

    User updateUser(User user);

    User createUser(UserRegistrationDto user) throws EmailExistsException;

    void deleteUser(User user);
}
