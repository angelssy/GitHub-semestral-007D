package com.ecomarket.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.ecomarket.model.Producto;
import com.ecomarket.service.GestiondeProductoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

@WebMvcTest(GestiondeProductoController.class)
class GestiondeProductoTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GestiondeProductoService service;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    void listarProductos_retorna200() throws Exception {
        when(service.obtenerTodosLosProductos()).thenReturn(List.of(
                new Producto(1, "Laptop", "Desc1", 1000.0, 10)
        ));

        mockMvc.perform(get("/products/gestion"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Laptop"));
    }

    @Test
    void agregarProducto_retorna201() throws Exception {
        Producto producto = new Producto(1, "Monitor", "4K", 300.0, 8);
        when(service.agregarProducto(any())).thenReturn(producto);

        mockMvc.perform(post("/products/gestion")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(producto)))
                .andExpect(status().isOk());
    }

    @Test
    void modificarProducto_retorna200() throws Exception {
        Producto producto = new Producto(1, "Teclado", "RGB", 50.0, 15);
        when(service.modificarProducto(eq(1), any())).thenReturn(producto);

        mockMvc.perform(put("/products/gestion/1")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(producto)))
                .andExpect(status().isOk());
    }

    @Test
    void eliminarProducto_retorna200() throws Exception {
        doNothing().when(service).eliminarProductoPorId(1);
        mockMvc.perform(delete("/products/gestion/1"))
                .andExpect(status().isOk());
    }
}
