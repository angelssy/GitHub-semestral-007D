package com.ecomarket.service;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import com.ecomarket.model.UsuarioAdmin;
import com.ecomarket.repository.UsuarioAdminRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UsuarioAdminTest {

    @Mock
    private UsuarioAdminRepository repository;

    @InjectMocks
    private UsuarioAdminService service;

    // Test 1: Desactivar usuario (éxito)
    @Test
    void desactivarUsuario_cambiaEstadoAFalse() {
        UsuarioAdmin admin = new UsuarioAdmin();
        admin.setId(1);
        admin.setActive(true);
        when(repository.findById(1)).thenReturn(Optional.of(admin));
        when(repository.save(any())).thenReturn(admin);

        service.desactivarUsuario(1);
        assertThat(admin.isActive()).isFalse();
    }

    // Test 2: Eliminar usuario (éxito)
    @Test
    void eliminarUsuario_llamaAlRepositorio() {
        doNothing().when(repository).deleteById(1);
        service.eliminarUsuarioPorId(1);
        verify(repository, times(1)).deleteById(1);
    }
}
