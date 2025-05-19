package com.ecomarket.repository;

import com.ecomarket.model.Usuario;
import com.ecomarket.service.UsuarioService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UsuarioRepository {

    private List<Usuario> listaUsuarios = new ArrayList<>();

    public List<Usuario> obtenerUsuarios() {
        return listaUsuarios;
    }

    public Usuario buscarPorId(int id) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario guardar(Usuario us) {
        listaUsuarios.add(us);
        return us;
    }

    public Usuario actualizar(Usuario us) {
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getId() == us.getId()) {
                id = us.getId();
                idPosicion = i;
            }

        }
        Usuario usuario1 = new Usuario();
        usuario1.setId(id);
        usuario1.setNombre(us.getNombre());
        usuario1.setApellido(us.getApellido());
        usuario1.setEmail(us.getEmail());
        usuario1.setTelefono(us.getTelefono());
        usuario1.setPassword(us.getPassword());

        listaUsuarios.set(idPosicion, usuario1);
        return usuario1;
    }

    public void eliminar(int id) {
        //alternativa 1
        Usuario usuario = buscarPorId(id);
        if (usuario != null) {
            listaUsuarios.remove(usuario);
        }

    }
}
