package com.upeu.cgk_usuario.service;

import com.upeu.cgk_usuario.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    // Listar todos los usuarios
    List<Usuario> listarUsuarios();

    // Obtener un usuario por ID
    Optional<Usuario> obtenerUsuarioPorId(Long id);

    // Guardar un nuevo usuario
    Usuario guardarUsuario(Usuario usuario);

    // Actualizar un usuario existente
    Usuario actualizarUsuario(Long id, Usuario usuario);

    // Eliminar un usuario por ID
    void eliminarUsuario(Long id);
}
