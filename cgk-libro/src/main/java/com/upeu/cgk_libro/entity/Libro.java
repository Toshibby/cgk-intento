package com.upeu.cgk_libro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Long id;

    @Column(nullable = false, length = 255, name = "titulo")
    private String titulo;

    @Column(nullable = false, length = 255, name = "autor")
    private String autor;

    @Column(nullable = false, length = 255, name = "editorial")
    private String editorial;

    @Column(nullable = false, length = 100, name = "categoria")
    private String categoria;

    @Column(nullable = false, name = "copias_totales")
    private Integer copiasTotales;

    @Column(nullable = false, name = "copias_disponibles")
    private Integer copiasDisponibles;
}
