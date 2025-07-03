package com.ecomarket.controller;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.ecomarket.model.Proovedores;
import com.ecomarket.service.ProovedoresService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ProovedoresController.class)
class ProovedoresTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProovedoresService service;

    @Test
    void getProovedores_retorna200() throws Exception {
        when(ProovedoresService.listarProovedores()).thenReturn("Lista de proveedores");
        mockMvc.perform(get("/proovedores"))
                .andExpect(status().isOk());
    }

    @Test
    void postProovedores_retorna200() throws Exception {
        when(service.agregarProovedor(any())).thenReturn("Proveedor agregado");
        mockMvc.perform(post("/proovedores"))
                .andExpect(status().isOk());
    }
}
