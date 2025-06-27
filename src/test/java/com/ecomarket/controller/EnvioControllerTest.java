package com.ecomarket.controller;

import com.ecomarket.model.Envio;
import com.ecomarket.service.EnvioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
class EnvioControllerTest {

    @Mock
    private EnvioService envioService;

    @InjectMocks
    private EnvioController envioController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEnvio_ReturnsList() {
        // Configuración
        when(envioService.listarEnvio()).thenReturn("Lista de envíos");

        // Ejecución
        String result = envioController.getEnvio();

        // Verificación
        assertEquals("Lista de envíos", result);
        verify(envioService, times(1)).listarEnvio();
    }

    @Test
    void testPostEnvio_ReturnsSuccessMessage() {
        // Configuración
        Envio envio = new Envio(/* parámetros del constructor */);
        when(envioService.agregarEnvio(any(Envio.class))).thenReturn("Envío agregado");

        // Ejecución
        String result = envioController.postEnvio(envio);

        // Verificación
        assertEquals("Envío agregado", result);
        verify(envioService, times(1)).agregarEnvio(envio);
    }

    @Test
    void testGetEnvioById_ReturnsEnvio() {
        // Configuración
        when(envioService.obtenerEnvioPorId(1)).thenReturn("Envío 1");

        // Ejecución
        String result = envioController.getEnvioById(1);

        // Verificación
        assertEquals("Envío 1", result);
        verify(envioService, times(1)).obtenerEnvioPorId(1);
    }

    @Test
    void testDeleteEnvioById_ReturnsSuccessMessage() {
        // Configuración
        when(envioService.eliminarEnvio(1)).thenReturn("Envío eliminado");

        // Ejecución
        String result = envioController.deleteEnvioById(1);

        // Verificación
        assertEquals("Envío eliminado", result);
        verify(envioService, times(1)).eliminarEnvio(1);
    }

    @Test
    void testPutEnvioById_ReturnsUpdatedEnvio() {
        // Configuración
        Envio envio = new Envio(/* parámetros */1, "Dirección 123");
        when(envioService.actualizarEnvio(eq(1), any(Envio.class))).thenReturn("Envío actualizado");

        // Ejecución
        String result = envioController.putEnvioById(1, envio);

        // Verificación
        assertEquals("Envío actualizado", result);
        verify(envioService, times(1)).actualizarEnvio(1, envio);
    }
}