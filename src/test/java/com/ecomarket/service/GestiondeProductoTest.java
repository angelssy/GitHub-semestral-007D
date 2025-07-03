package com.ecomarket.service;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import com.ecomarket.model.Producto;
import com.ecomarket.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class GestiondeProductoTest {

    @Mock
    private ProductoRepository repository;

    @InjectMocks
    private GestiondeProductoService service;

    @Test
    void listarProductos_retornaLista() {
        when(repository.findAll()).thenReturn(List.of(
                new Producto(1, "Laptop", "Desc1", 1000.0, 10),
                new Producto(1, "Mouse", "Desc2", 20.0, 50)
        ));

        List<Producto> productos = service.obtenerTodosLosProductos();
        assertThat(productos).hasSize(2);
    }

    @Test
    void modificarProducto_retornaActualizado() {
        Producto producto = new Producto(1, "Teclado", "Nuevo", 50.0, 5);
        when(repository.save(any())).thenReturn(producto);

        Producto actualizado = service.modificarProducto(1, producto);
        assertThat(actualizado.getName()).isEqualTo("Teclado");
    }

    @Test
    void eliminarProducto_verificaRepositorio() {
        doNothing().when(repository).deleteById(1);
        service.eliminarProductoPorId(1);
        verify(repository, times(1)).deleteById(1);
    }

    @Test
    void agregarProducto_retornaGuardado() {
        Producto producto = new Producto(1, "Monitor", "4K", 300.0, 8);
        when(repository.save(producto)).thenReturn(new Producto(1, "Monitor", "4K", 300.0, 8));

        Producto guardado = service.agregarProducto(producto);
        assertThat(guardado.getId()).isEqualTo(3);
    }
}
