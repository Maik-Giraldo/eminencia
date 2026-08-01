package com.eminencia.gestionusuarios.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity // no crea un bean
@Table(name = "users")
public class Users {

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremental
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "age")
    private Long age;

    @Column(name = "email")
    private String email;
}
