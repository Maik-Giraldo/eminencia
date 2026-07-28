package com.eminencia.gestionusuarios.dto;

import lombok.Data;

@Data
public class UserRequestDTO {
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
