package com.ecomarket.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.ecomarket.model.UsuarioAdmin;
import com.ecomarket.service.UsuarioAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UsuarioAdminController.class)
public class UsuarioAdminTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioAdminService service;

    // Test 1: PUT /usuario/admin/{id}/desactivar (éxito)
    @Test
    void desactivarUsuario_retorna200() throws Exception {
        doNothing().when(service).desactivarUsuario(1);
        mockMvc.perform(put("/usuario/admin/1/desactivar"))
                .andExpect(status().isOk());
    }

    // Test 2: DELETE /usuario/admin/{id} (éxito)
    @Test
    void eliminarUsuario_retorna200() throws Exception {
        doNothing().when(service).eliminarUsuarioPorId(1);
        mockMvc.perform(delete("/usuario/admin/1"))
                .andExpect(status().isOk());
    }
}
