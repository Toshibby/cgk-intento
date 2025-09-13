package com.upeu.cgk_prestamo.service;

import com.upeu.cgk_prestamo.dto.PrestamoDTO;
import com.upeu.cgk_prestamo.entity.Prestamo;

import java.util.List;
import java.util.Optional;

public interface PrestamoService {

    // Listar todos los préstamos
    List<PrestamoDTO> listarPrestamos();

    // Obtener un préstamo por ID
    Optional<PrestamoDTO> obtenerPrestamoPorId(Long id);

    // Guardar un nuevo préstamo
    PrestamoDTO guardarPrestamo(PrestamoDTO prestamoDTO);

    // Actualizar un préstamo existente
    PrestamoDTO actualizarPrestamo(Long id, PrestamoDTO prestamoDTO);

    // Eliminar un préstamo por ID
    void eliminarPrestamo(Long id);
}
