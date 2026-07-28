package com.eminencia.gestionusuarios.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eminencia.gestionusuarios.dto.UserRequestDTO;
import com.eminencia.gestionusuarios.dto.UserResponseDTO;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(UserRequestDTO request) {

    }
}
