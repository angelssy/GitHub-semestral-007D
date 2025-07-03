package com.ecomarket.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.ecomarket.model.Producto;
import com.ecomarket.service.ProductoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ProductoController.class)
public class ProductoTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoService service;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    void getProductoById_retorna200() throws Exception {
        Producto producto = new Producto(1, "Teclado", "Mecánico", 80.0, 15);
        when(service.obtenerProductoPorId(1)).thenReturn(String.valueOf(producto));

        mockMvc.perform(get("/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Teclado"));
    }

    @Test
    void agregarProducto_retorna201() throws Exception {
        Producto nuevo = new Producto(1, "Mouse", "Inalámbrico", 25.0, 30);
        when(service.agregarProducto(any())).thenReturn(String.valueOf(nuevo));

        mockMvc.perform(post("/products")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(nuevo)))
                .andExpect(status().isOk());
    }
}
