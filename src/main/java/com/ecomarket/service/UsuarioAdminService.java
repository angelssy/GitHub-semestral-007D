package com.ecomarket.service;

import com.ecomarket.model.UsuarioAdmin;
import com.ecomarket.model.Usuario;
import com.ecomarket.repository.Usuariorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioAdminService {
    @Autowired
    private Usuariorepository usuariorepository;

    // Listar todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuariorepository.findAll();
    }

    // Agregar usuario
    public Usuario agregarUsuario(Usuario nuevoUsuario) {
        nuevoUsuario.setActive(true);
        return usuariorepository.save(nuevoUsuario);
    }

    // Modificar usuario
    public Usuario modificarUsuario(int id, Usuario datosActualizados) {
        Optional<Usuario> usuario = usuariorepository.findById(id);
        if (usuario.isPresent()) {
            Usuario existente = usuario.get();
            existente.setUsername(datosActualizados.getUsername());
            existente.setEmail(datosActualizados.getEmail());
            existente.setPassword(datosActualizados.getPassword());
            return usuariorepository.save(existente);
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
    }

    // Desactivar usuario (soft delete)
    public void desactivarUsuario(int id) {
        Optional<Usuario> usuario = usuariorepository.findById(id);
        if (usuario.isPresent()) {
            Usuario existente = usuario.get();
            existente.setActive(false);
            usuariorepository.save(existente);
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
    }
    // Se elimina el usuario por id
    public void eliminarUsuarioPorId(int id) {
        Optional<Usuario> usuario = usuariorepository.findById(id);
        if (usuario.isPresent()) {
            usuariorepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
    }
}
