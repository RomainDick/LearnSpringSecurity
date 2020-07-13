package com.example.demo.dto;

import lombok.*;

@Getter
@AllArgsConstructor
public class AuthenticationResponse {
    private final String jwt;
}
