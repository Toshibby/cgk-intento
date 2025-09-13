package com.upeu.cgk_prestamo.service;

import com.upeu.cgk_prestamo.entity.Prestamo;

import java.util.List;
import java.util.Optional;

public interface PrestamoService {

    // Listar todos los préstamos
    List<Prestamo> listarPrestamos();

    // Obtener un préstamo por ID
    Optional<Prestamo> obtenerPrestamoPorId(Long id);

    // Guardar un nuevo préstamo
    Prestamo guardarPrestamo(Prestamo prestamo);

    // Actualizar un préstamo existente
    Prestamo actualizarPrestamo(Long id, Prestamo prestamo);

    // Eliminar un préstamo por ID
    void eliminarPrestamo(Long id);
}
