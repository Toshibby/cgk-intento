package com.upeu.cgk_prestamo.service.impl;

import com.upeu.cgk_prestamo.dto.LibroDTO;
import com.upeu.cgk_prestamo.dto.PrestamoDTO;
import com.upeu.cgk_prestamo.dto.UsuarioDTO;
import com.upeu.cgk_prestamo.entity.Prestamo;
import com.upeu.cgk_prestamo.feign.LibroFeign;
import com.upeu.cgk_prestamo.feign.UsuarioFeign;
import com.upeu.cgk_prestamo.repository.PrestamoRepository;
import com.upeu.cgk_prestamo.service.PrestamoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final UsuarioFeign usuarioFeign;
    private final LibroFeign libroFeign;

    public PrestamoServiceImpl(PrestamoRepository prestamoRepository,
                               UsuarioFeign usuarioFeign,
                               LibroFeign libroFeign) {
        this.prestamoRepository = prestamoRepository;
        this.usuarioFeign = usuarioFeign;
        this.libroFeign = libroFeign;
    }

    // Método para convertir entidad a DTO y llenar datos remotos
    private PrestamoDTO mapToDTO(Prestamo prestamo) {
        PrestamoDTO dto = new PrestamoDTO();
        dto.setIdPrestamo(prestamo.getId());
        dto.setIdUsuario(prestamo.getIdUsuario());
        dto.setIdLibro(prestamo.getIdLibro());
        dto.setFechaPrestamo(prestamo.getFechaPrestamo());
        dto.setFechaDevolucion(prestamo.getFechaDevolucion());
        dto.setEstado(prestamo.getEstado());

        // Llamadas a microservicios remotos
        UsuarioDTO usuario = usuarioFeign.buscarPorId(prestamo.getIdUsuario());
        LibroDTO libro = libroFeign.buscarPorId(prestamo.getIdLibro());

        dto.setUsuario(usuario);
        dto.setLibro(libro);

        return dto;
    }

    // Método para convertir DTO a entidad
    private Prestamo mapToEntity(PrestamoDTO dto) {
        Prestamo prestamo = new Prestamo();
        prestamo.setId(dto.getIdPrestamo());
        prestamo.setIdUsuario(dto.getIdUsuario());
        prestamo.setIdLibro(dto.getIdLibro());
        prestamo.setFechaPrestamo(dto.getFechaPrestamo());
        prestamo.setFechaDevolucion(dto.getFechaDevolucion());
        prestamo.setEstado(dto.getEstado());
        return prestamo;
    }

    @Override
    public List<PrestamoDTO> listarPrestamos() {
        return prestamoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PrestamoDTO> obtenerPrestamoPorId(Long id) {
        return prestamoRepository.findById(id)
                .map(this::mapToDTO);
    }

    @Override
    public PrestamoDTO guardarPrestamo(PrestamoDTO prestamoDTO) {
        Prestamo prestamo = mapToEntity(prestamoDTO);
        Prestamo guardado = prestamoRepository.save(prestamo);
        return mapToDTO(guardado);
    }

    @Override
    public PrestamoDTO actualizarPrestamo(Long id, PrestamoDTO prestamoDTO) {
        Prestamo actualizado = prestamoRepository.findById(id)
                .map(p -> {
                    p.setIdUsuario(prestamoDTO.getIdUsuario());
                    p.setIdLibro(prestamoDTO.getIdLibro());
                    p.setFechaPrestamo(prestamoDTO.getFechaPrestamo());
                    p.setFechaDevolucion(prestamoDTO.getFechaDevolucion());
                    p.setEstado(prestamoDTO.getEstado());
                    return prestamoRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));
        return mapToDTO(actualizado);
    }

    @Override
    public void eliminarPrestamo(Long id) {
        prestamoRepository.deleteById(id);
    }
}
