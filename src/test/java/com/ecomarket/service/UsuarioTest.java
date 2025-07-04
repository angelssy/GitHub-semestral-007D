package com.ecomarket.service;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import com.ecomarket.model.Usuario;
import com.ecomarket.repository.Usuariorepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
 class UsuarioTest {

    @Mock
    private Usuariorepository repository;

    @InjectMocks
    private UsuarioService service;

    // Test 1: Obtener usuario por ID (éxito)
    @Test
    void obtenerUsuarioPorId_retornaUsuario() {
        Usuario usuarioMock = new Usuario(1, "user1", "pass1", "user1@test.com", true);
        when(repository.findById(1)).thenReturn(Optional.of(usuarioMock));

        Usuario resultado = service.obtenerUsuarioPorId(1);
        assertThat(resultado.getUsername()).isEqualTo("user1");
    }

    // Test 2: Obtener usuario por ID (error)
    @Test
    void obtenerUsuarioPorId_usuarioNoExiste() {
        when(repository.findById(99)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> service.obtenerUsuarioPorId(99))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Usuario no encontrado");
    }
}
