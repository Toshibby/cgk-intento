package com.upeu.cgk_prestamo.controller;

import com.upeu.cgk_prestamo.dto.PrestamoDTO;
import com.upeu.cgk_prestamo.service.PrestamoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    // Listar todos los préstamos
    @GetMapping
    public ResponseEntity<List<PrestamoDTO>> listarPrestamos() {
        List<PrestamoDTO> prestamos = prestamoService.listarPrestamos();
        return ResponseEntity.ok(prestamos);
    }

    // Obtener un préstamo por ID
    @GetMapping("/{id}")
    public ResponseEntity<PrestamoDTO> obtenerPrestamo(@PathVariable Long id) {
        return prestamoService.obtenerPrestamoPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo préstamo
    @PostMapping
    public ResponseEntity<PrestamoDTO> crearPrestamo(@RequestBody PrestamoDTO prestamoDTO) {
        PrestamoDTO guardado = prestamoService.guardarPrestamo(prestamoDTO);
        return ResponseEntity.ok(guardado);
    }

    // Actualizar un préstamo
    @PutMapping("/{id}")
    public ResponseEntity<PrestamoDTO> actualizarPrestamo(@PathVariable Long id, @RequestBody PrestamoDTO prestamoDTO) {
        try {
            PrestamoDTO actualizado = prestamoService.actualizarPrestamo(id, prestamoDTO);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un préstamo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrestamo(@PathVariable Long id) {
        prestamoService.eliminarPrestamo(id);
        return ResponseEntity.noContent().build();
    }
}
