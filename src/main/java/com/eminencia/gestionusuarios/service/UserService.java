package com.eminencia.gestionusuarios.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    /**
     * Método para crear usuarios
     * 
     * @param request
     * @return
     */
    public UserResponseDTO createUser(UserRequestDTO request) throws Exception {
        Optional<Users> userFound = userRepository.findFirstByUsername(request.getUsername());

        if (userFound.isPresent()) {
            throw new Exception("El nombre ya esta en uso");
        }
        
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

    /**
     * Metodo para obtener todos los usuarios
     * 
     * @return
     */
    public List<UserResponseDTO> getAllUsers() {
        List<UserResponseDTO> response = new ArrayList<>();
        List<Users> usersFound = userRepository.findAll();
        
        for (Users userFound : usersFound) {
            UserResponseDTO user = new UserResponseDTO();
            user.setId(userFound.getId());
            user.setUsername(userFound.getUsername());
            user.setAge(userFound.getAge());
            user.setEmail(userFound.getEmail());

            response.add(user);
        }

        return response;
    }

    public UserResponseDTO getUser(Long id) throws Exception{
        Optional<Users> userFound = userRepository.findById(id);

        if(userFound.isEmpty()) {
            throw new Exception("usuario no encontrado");
        }

        Users user = userFound.get();


        UserResponseDTO response = new UserResponseDTO();
        response.setId(user.getId());
        response.setAge(user.getAge());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());

        return response;
    }
}
