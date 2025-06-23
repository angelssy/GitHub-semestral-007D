package com.ecomarket.controller;
import com.ecomarket.model.*;
import com.ecomarket.repository.*;
import com.ecomarket.service.UsuarioAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario/admin")
public class UsuarioAdminController {

    @Autowired
    private UsuarioAdminService usuarioAdminService;

    // Listar todos los usuarios

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioAdminService.obtenerTodosLosUsuarios();
    }


    // Agregar usuario en el postman http://localhost:8080/users/admin (POST-BODY-RAW-JSON)

    @PostMapping
    public ResponseEntity<Usuario> agregarUsuario(@RequestBody Usuario nuevoUsuario) {
        Usuario creado = usuarioAdminService.agregarUsuario(nuevoUsuario);
        return ResponseEntity.ok(creado);
    }

    // Modificar usuario

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> modificarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        try {
            Usuario actualizado = usuarioAdminService.modificarUsuario(id, usuario);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Desactiva usuario

    @PutMapping("/{id}/desactivar")
    public ResponseEntity<String> desactivarUsuario(@PathVariable int id) {
        try {
            usuarioAdminService.desactivarUsuario(id);
            return ResponseEntity.ok("Usuario desactivado.");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }



    // Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable int id) {
        try {
           usuarioAdminService.eliminarUsuarioPorId(id);
            return ResponseEntity.ok("Usuario eliminado.");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
