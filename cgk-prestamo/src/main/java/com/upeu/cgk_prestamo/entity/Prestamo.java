package com.upeu.cgk_prestamo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prestamo")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamo")
    private Long id;

    // Referencia lógica al microservicio de usuario (no es FK real, sino ID que viene de ms-usuario)
    @Column(nullable = false, name = "id_usuario")
    private Long idUsuario;

    // Referencia lógica al microservicio de libro (no es FK real, sino ID que viene de ms-libro)
    @Column(nullable = false, name = "id_libro")
    private Long idLibro;

    @Column(nullable = false, name = "fecha_prestamo")
    private LocalDate fechaPrestamo;

    @Column(nullable = false, name = "fecha_devolucion")
    private LocalDate fechaDevolucion;

    @Column(nullable = false, length = 20, name = "estado")
    private String estado; // ACTIVO, DEVUELTO, ATRASADO
}
