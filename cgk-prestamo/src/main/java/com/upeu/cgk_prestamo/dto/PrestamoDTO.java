package com.upeu.cgk_prestamo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class PrestamoDTO {
    private Long idPrestamo;
    private Long idUsuario;      // referencia lógica al usuario (desde ms-usuario)
    private Long idLibro;        // referencia lógica al libro (desde ms-libro)
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private String estado;

    private UsuarioDTO usuario;
    private LibroDTO libro;
}
