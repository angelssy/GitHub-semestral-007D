package com.ecomarket.service;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import com.ecomarket.model.Producto;
import com.ecomarket.repository.ProductoRepository;
import org.assertj.core.api.AbstractStringAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
 class ProductoTest {

    @Mock
    private ProductoRepository repository;

    @InjectMocks
    private ProductoService service;

    @Test
    void obtenerProductoPorId_retornaProducto() {
        Producto productoMock = new Producto(1, "Laptop", "Gamer", 1500.0, 10);
        when(repository.findById(1)).thenReturn(Optional.of(productoMock));

        String resultado = service.obtenerProductoPorId(1);
        AbstractStringAssert<?> laptop = assertThat(resultado).isEqualTo("Laptop");
    }

    @Test
    void eliminarProducto_verificaRepositorio() {
        doNothing().when(repository).deleteById(1);
        service.listarProductos();
        verify(repository, times(1)).deleteById(1);
    }
}
