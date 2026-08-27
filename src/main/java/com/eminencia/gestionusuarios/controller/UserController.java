package com.eminencia.gestionusuarios.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eminencia.gestionusuarios.dto.UserRequestDTO;
import com.eminencia.gestionusuarios.dto.UserResponseDTO;
import com.eminencia.gestionusuarios.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor // Crea un constructor con los argumentos que lo requieran
@RequestMapping("/users") // Context path (ruta de contexto para este controller)
public class UserController {

    // Inyección de dependencias
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO request) throws Exception {
        UserResponseDTO response = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
