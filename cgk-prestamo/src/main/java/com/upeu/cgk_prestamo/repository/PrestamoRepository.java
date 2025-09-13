package com.upeu.cgk_prestamo.repository;

import com.upeu.cgk_prestamo.entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo,Long> {
    // Buscar prestamos activos por usuario (para controlar cantidad máxima)
    List<Prestamo> findByIdUsuarioAndEstado(Long idUsuario, String estado);

    // Opcional: listar por libro si necesitas verificar disponibilidad
    List<Prestamo> findByIdLibroAndEstado(Long idLibro, String estado);
}
