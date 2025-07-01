package com.ecomarket.controller;



import com.ecomarket.assemblers.UsuarioAssembler;
import com.ecomarket.model.Usuario;
import com.ecomarket.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;


@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuarios", description = "Operaciones CRUD para usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioAssembler usuarioAssembler;
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

    @GetMapping("/{id}")
    @Operation(summary = "Obtener usuario por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuario encontrado"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public ResponseEntity<Usuariomodel> getUsuarioById(
            @Parameter(description = "ID del usuario") @PathVariable Long id) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        return ResponseEntity.ok(usuarioAssembler.toModel(usuario));
    }

    // ... otros métodos con anotaciones similares
}

}
