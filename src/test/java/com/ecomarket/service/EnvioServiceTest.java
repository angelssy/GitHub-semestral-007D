package com.ecomarket.service;
import com.ecomarket.model.Envio;
import com.ecomarket.repository.EnvioRepository;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
@ExtendWith(MockitoExtension.class)
class EnvioServiceTest {

    @Mock
    private EnvioRepository envioRepository;

    @InjectMocks
    private EnvioService envioService;

    @Test
    public void testObtenerEnvioPorId() {
        // Configuración
        Envio envioMock = new Envio();
        when(envioRepository.findById(1)).thenReturn(Optional.of(envioMock)); // <- ¡Ojo al thenReturn!

        // Ejecución
        String resultado = envioService.obtenerEnvioPorId(1);

        // Verificación
        assertEquals("Envío encontrado", resultado);
        verify(envioRepository, times(1)).findById(1); // <- Punto y coma aquí
    }

    @Test
    public void testEliminarEnvio() {
        // Configuración para método void
        doNothing().when(envioRepository).deleteById(1); // <- Sintaxis correcta

        // Ejecución
        String resultado = envioService.eliminarEnvio(1);

        // Verificación
        assertEquals("Envío eliminado", resultado);
    }
}