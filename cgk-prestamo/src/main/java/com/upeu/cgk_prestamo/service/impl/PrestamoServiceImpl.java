package com.upeu.cgk_prestamo.service.impl;

import com.upeu.cgk_prestamo.entity.Prestamo;
import com.upeu.cgk_prestamo.repository.PrestamoRepository;
import com.upeu.cgk_prestamo.service.PrestamoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoRepository prestamoRepository;

    public PrestamoServiceImpl(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    @Override
    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.findAll();
    }

    @Override
    public Optional<Prestamo> obtenerPrestamoPorId(Long id) {
        return prestamoRepository.findById(id);
    }

    @Override
    public Prestamo guardarPrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo actualizarPrestamo(Long id, Prestamo prestamo) {
        return prestamoRepository.findById(id)
                .map(p -> {
                    p.setIdUsuario(prestamo.getIdUsuario());
                    p.setIdLibro(prestamo.getIdLibro());
                    p.setFechaPrestamo(prestamo.getFechaPrestamo());
                    p.setFechaDevolucion(prestamo.getFechaDevolucion());
                    p.setEstado(prestamo.getEstado());
                    return prestamoRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));
    }

    @Override
    public void eliminarPrestamo(Long id) {
        prestamoRepository.deleteById(id);
    }
}
