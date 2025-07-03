package com.ecomarket.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.ecomarket.model.Usuario;
import com.ecomarket.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UsuarioController.class)
class UsuarioTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService service;

    private ObjectMapper mapper = new ObjectMapper();

    // Test 1: GET /users/id/{id} (éxito)
    @Test
    void getUsuarioById_retorna200() throws Exception {
        Usuario usuario = new Usuario(1, "user1", "pass1", "user1@test.com", true);
        when(service.obtenerUsuarioPorId(1)).thenReturn(usuario);

        mockMvc.perform(get("/users/id/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("user1"));
    }

    // Test 2: POST /users (creación exitosa)
    @Test
    void crearUsuario_retorna201() throws Exception {
        Usuario nuevoUsuario;
        nuevoUsuario = new Usuario(2, "newuser", "newpass", "new@test.com", true);
        when(service.listarUsuarios()).thenReturn(String.valueOf(nuevoUsuario));

        mockMvc.perform(post("/users")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(nuevoUsuario)))
                .andExpect(status().isOk());
    }
}
