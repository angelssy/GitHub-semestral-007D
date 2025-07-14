package com.ecomarket.service;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import com.ecomarket.model.Gestiondeenvio;
import com.ecomarket.repository.GestiondeenvioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
 class GestiondeenvioTest {

    @Mock
    private GestiondeenvioRepository repository;

    @InjectMocks
    private GestiondeenvioService service;

    @Test
    void cuandoExisteId_retornaGestiondeenvio() {
        Gestiondeenvio envioMock = new Gestiondeenvio(1, "Envio1", "envio1@test.com", "ABC123");
        when(repository.findById(1)).thenReturn(Optional.of(envioMock));

    }

    @Test
    void cuandoNoExisteId_lanzaExcepcion() {
        when(repository.findById(99)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> service.obtenerGestiondeenvioPorId(99))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Gestión de envío no encontrada");
    }

    @Test
    void cuandoAgregaEnvio_retornaEnvioGuardado() {
        Gestiondeenvio nuevoEnvio = new Gestiondeenvio();
        when(repository.save(nuevoEnvio)).thenReturn(new Gestiondeenvio(1, "Nuevo", "nuevo@test.com", "XYZ789"));


    }

    @Test
    void cuandoEliminaEnvio_verificaRepositorio() {
        doNothing().when(repository).deleteById(1);
        service.eliminarGestiondeenvio(1);
        verify(repository, times(1)).deleteById(1);
    }
}
