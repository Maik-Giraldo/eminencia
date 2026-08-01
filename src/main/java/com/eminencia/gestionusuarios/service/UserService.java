package com.eminencia.gestionusuarios.service;

import org.springframework.stereotype.Service;

import com.eminencia.gestionusuarios.dto.UserRequestDTO;
import com.eminencia.gestionusuarios.dto.UserResponseDTO;
import com.eminencia.gestionusuarios.entity.Users;
import com.eminencia.gestionusuarios.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service // bean 
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    
    public UserResponseDTO createUser(UserRequestDTO request) {
        Users user = new Users();
        user.setUsername(request.getUsername());
        user.setAge(request.getAge());
        user.setEmail(request.getEmail());
        userRepository.save(user);

        UserResponseDTO response = new UserResponseDTO();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setAge(user.getAge());
        response.setEmail(user.getEmail());

        return response;
    }
}
