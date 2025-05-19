package com.ecomarket.service;

import com.ecomarket.model.Usuario;
import com.ecomarket.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios() {
        return usuarioRepository.obtenerUsuarios();

    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.guardar(usuario);

    }
    public Usuario getUsuario(int id) {
        return usuarioRepository.buscarPorId(id);

    }
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.actualizar(usuario);
    }

    public String deleteLibro(int id) {
        usuarioRepository.eliminar(id);
        return "Usuario eliminado";
    }

}
