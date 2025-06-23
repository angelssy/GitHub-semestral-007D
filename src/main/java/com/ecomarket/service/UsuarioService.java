package com.ecomarket.service;


import com.ecomarket.model.Usuario;
import com.ecomarket.repository.Usuariorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UsuarioService {

    @Autowired
    Usuariorepository usuariorepository;

    public String agregarUser(Usuario usuario) {
        usuariorepository.save(usuario);
        return "se a agregado usuario con id " + usuario.getId();
    }

    public String listarUsuarios() {
        String output = "";
        for (Usuario usuario : usuariorepository.findAll()) {
            output += "Id usuario: " + usuario.getId() + "\n";
            output += "nombre de usuario: " + usuario.getUsername() + "\n";
            output += "contraseña: " + usuario.getPassword() + "\n";
            output += "correo: " + usuario.getEmail() + "\n";

        }
        if (output.isEmpty()) {
            return "no hay usuarios";
        } else {
            return output;
        }
    }

    public String obtenerUsuarioporId(int id) {
        String output = "";
        if (usuariorepository.existsById(id)) {
            Usuario usuario = usuariorepository.findById(id).get();
            output += "ID usuario: " + usuario.getId() + "\n";
            output += "Nombre de usuario: " + usuario.getUsername() + "\n";
            output += "Contraseña: " + usuario.getPassword() + "\n";
            output += "Correo: " + usuario.getEmail() + "\n";
            return output;
        } else {
            return "No existe un producto con ese id";
        }
    }

    public String eliminarUsuario(int id){
        if (usuariorepository.existsById(id)){
            usuariorepository.deleteById(id);
            return "Se ha eliminado el producto con id: "+id;
        }else{
            return "No existe un producto con ese id";
        }
    }

    public String actualizarUsuario(int id, Usuario usuario){
        if (usuariorepository.existsById(id)){
            Usuario buscado=usuariorepository.findById(id).get();
            buscado.setUsername(usuario.getUsername());
            buscado.setPassword(usuario.getPassword());
            buscado.setEmail(usuario.getEmail());
            usuariorepository.save(buscado);
            return "Se ha actualizado el usuario con id: "+id;
        }else {
            return "No existe un usuario con ese id";
        }
    }



}
