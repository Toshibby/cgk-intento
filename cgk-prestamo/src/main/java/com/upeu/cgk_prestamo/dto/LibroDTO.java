package com.upeu.cgk_prestamo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class LibroDTO {
    private Long idLibro;
    private String titulo;
    private String autor;
    private String editorial;
    private String categoria;
    private Integer copiasTotales;
    private Integer copiasDisponibles;
}
