package com.ecomarket.service;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import com.ecomarket.model.Proovedores;
import com.ecomarket.repository.ProovedoresRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProovedoresTest {

    @Mock
    private ProovedoresRepository repository;

    @InjectMocks
    private ProovedoresService service;

    @Test
    void listarProovedores_retornaLista() {
        when(repository.findAll()).thenReturn(List.of(
                new Proovedores(1, "ProveedorA", "a@test.com"),
                new Proovedores(2, "ProveedorB", "b@test.com")
        ));

        assertThat(ProovedoresService.listarProovedores()).hasSize(2);
    }

    @Test
    void eliminarProovedor_verificaRepositorio() {
        doNothing().when(repository).deleteById(1);
        service.eliminarProovedor(1);
        verify(repository, times(1)).deleteById(1);
    }
}
