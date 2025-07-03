package com.ecomarket.controller;

import com.ecomarket.model.Gestiondeenvio;
import com.ecomarket.service.GestiondeenvioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GestiondeenvioController.class)
public class GestiondeenvioTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GestiondeenvioService service;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void obtenerEnvioPorId_retorna200() throws Exception {
        Gestiondeenvio envio = new Gestiondeenvio(1, "Envio1", "envio1@test.com", "ABC123");
        when(service.obtenerGestiondeenvioPorId(1)).thenReturn(envio);

        mockMvc.perform(get("/gestiondeenvios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.gestionName").value("Envio1"));
    }

    @Test
    void agregarEnvio_retorna201() throws Exception {
        Gestiondeenvio envio = new Gestiondeenvio();
        when(service.agregarGestiondeenvio(any())).thenReturn(envio);

        mockMvc.perform(post("/gestiondeenvios")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(envio)))
                .andExpect(status().isOk());
    }

    @Test
    void eliminarEnvio_retorna200() throws Exception {
        doNothing().when(service).eliminarGestiondeenvio(1);
        mockMvc.perform(delete("/gestiondeenvios/1"))
                .andExpect(status().isOk());
    }

    @Test
    void actualizarEnvio_retorna200() throws Exception {
        Gestiondeenvio envio = new Gestiondeenvio(1, "Actualizado", "actualizado@test.com", "DEF456");
        when(service.actualizarGestionEnvio(eq(1), any())).thenReturn(String.valueOf(envio));

        mockMvc.perform(put("/gestiondeenvios/1")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(envio)))
                .andExpect(status().isOk());
    }
}
