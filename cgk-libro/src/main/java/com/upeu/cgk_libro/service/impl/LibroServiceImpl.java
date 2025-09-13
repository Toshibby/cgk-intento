package com.upeu.cgk_libro.service.impl;

import com.upeu.cgk_libro.entity.Libro;
import com.upeu.cgk_libro.repository.LibroRepository;
import com.upeu.cgk_libro.service.LibroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    @Override
    public Optional<Libro> obtenerLibroPorId(Long id) {
        return libroRepository.findById(id);
    }

    @Override
    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro actualizarLibro(Long id, Libro libro) {
        return libroRepository.findById(id)
                .map(l -> {
                    l.setTitulo(libro.getTitulo());
                    l.setAutor(libro.getAutor());
                    l.setEditorial(libro.getEditorial());
                    l.setCategoria(libro.getCategoria());
                    l.setCopiasTotales(libro.getCopiasTotales());
                    l.setCopiasDisponibles(libro.getCopiasDisponibles());
                    return libroRepository.save(l);
                })
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con id " + id));
    }

    @Override
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }
}
