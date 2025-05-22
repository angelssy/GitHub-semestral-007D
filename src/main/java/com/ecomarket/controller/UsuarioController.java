package com.ecomarket.controller;



import com.ecomarket.model.Usuario;
import com.ecomarket.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/vi/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {return usuarioService.getUsuarios();}

    @PostMapping
    public Usuario addUsuario(@RequestBody Usuario usuario) {return usuarioService.saveUsuario(usuario);}

    @GetMapping("{id}")
    public Usuario buscarUsuario(@PathVariable int id) {
        return usuarioService.getUsuario(id);
    }

    @PutMapping("{id}")
    public Usuario actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(usuario);
    }
}
