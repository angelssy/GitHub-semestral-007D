package com.ecomarket.service;

import com.ecomarket.model.Producto;
import com.ecomarket.model.Usuario;
import com.ecomarket.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestiondeProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Listar todos los prodcutos
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    // Agregar Producto
    public Producto agregarProducto(Producto nuevoProducto) {
        return productoRepository.save(nuevoProducto);
    }

    // Modificar Producto
    public Producto modificarProducto(int id, Producto datosActualizados) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            Producto existente = producto.get();
            existente.setStock(datosActualizados.getStock());
            existente.setName(datosActualizados.getName());
            existente.setDescription(datosActualizados.getDescription());
            return productoRepository.save(existente);
        } else {
            throw new RuntimeException("Producto encontrado con ID: " + id);
        }
    }

    // Se elimina el producto por id
    public void eliminarProductoPorId(int id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            productoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
    }
}
