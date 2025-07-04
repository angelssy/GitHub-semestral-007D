package com.ecomarket.controller;



import com.ecomarket.model.Usuario;
import com.ecomarket.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String getUsers() {
        return usuarioService.listarUsuarios();
    }


    @GetMapping("/id/{id}")
    public String getUserById(@PathVariable int id) {
        return usuarioService.obtenerUsuarioporId(id);
    }



}
