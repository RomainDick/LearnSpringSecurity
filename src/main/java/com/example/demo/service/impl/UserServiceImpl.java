package com.example.demo.service.impl;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.exception.EmailExistsException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> getUser(Long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User createUser(UserRegistrationDto userRegistrationDto) throws EmailExistsException {
        if (emailExist(userRegistrationDto.getUsername())) {
            throw new EmailExistsException(
                    "There is an account with that email address :" + userRegistrationDto.getUsername()
            );
        }
        User user = new User(userRegistrationDto, passwordEncoder);

        return this.userRepository.save(user);
    }

    private boolean emailExist(String username) {
        if (this.userRepository.findByUsername(username) != null ) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteUser(User user) {
        this.userRepository.delete(user);
    }

}
