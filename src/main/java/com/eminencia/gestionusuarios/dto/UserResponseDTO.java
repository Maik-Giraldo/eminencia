package com.eminencia.gestionusuarios.dto;

import lombok.Data;

@Data
public class UserResponseDTO {
    /**
     * id del usuario
     */
    private Long id;

    /**
     * Nombre del usuario
     */
    private String username;

    /**
     * Edad del usuario
     */
    private Long age;

    /**
     * Email del usuario
     */
    private String email;
}
