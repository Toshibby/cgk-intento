package com.upeu.cgk_libro.service;

import com.upeu.cgk_libro.entity.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroService {
    List<Libro> listarLibros();


    Optional<Libro> obtenerLibroPorId(Long id);


    Libro guardarLibro(Libro libro);


    Libro actualizarLibro(Long id, Libro libro);

    void eliminarLibro(Long id);
}
