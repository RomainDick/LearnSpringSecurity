package com.example.demo.model;

import com.example.demo.dto.UserRegistrationDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Table(name = "USERS")
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    @JsonIgnore
    private String password;

    public User(UserRegistrationDto userRegistrationDto, PasswordEncoder passwordEncoder) {
        this.username = userRegistrationDto.getUsername();
        this.password = passwordEncoder.encode(userRegistrationDto.getPassword());
    }
}
