package com.upeu.cgk_usuario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(nullable = false, length = 100, name = "nombre")
    private String nombre;

    @Column(nullable = false, unique = true, length = 150, name = "correo")
    private String correo;

    @Column(nullable = false, length = 20, name = "tipo")
    private String tipo; // ALUMNO o DOCENTE

    @Column(length = 100, name = "carrera")
    private String carrera;

    @Column(nullable = false, length = 20, name = "estado")
    private String estado; // ACTIVO o INACTIVO
}
