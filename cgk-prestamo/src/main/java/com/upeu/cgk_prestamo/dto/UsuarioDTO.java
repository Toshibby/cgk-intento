package com.upeu.cgk_prestamo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class UsuarioDTO {
    private Long idUsuario;       // corresponde a id de Usuario
    private String nombre;
    private String correo;
    private String tipo;          // ALUMNO o DOCENTE
    private String carrera;       // puede ser null si no aplica
    private String estado;
}
