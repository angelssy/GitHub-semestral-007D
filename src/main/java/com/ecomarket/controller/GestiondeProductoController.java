package com.ecomarket.controller;

import com.ecomarket.model.GestiondeProducto;
import com.ecomarket.model.Producto;
import com.ecomarket.service.GestiondeProductoService;
import com.ecomarket.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/gestion")
public class GestiondeProductoController {
    @Autowired
    private GestiondeProductoService gestiondeProductoService;

    // Listar todos
    @GetMapping
    public List<Producto> listarProductos() {
        return gestiondeProductoService.obtenerTodosLosProductos();
    }

    // Agregar Producto
    @PostMapping
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto nuevoProducto) {
        Producto creado = gestiondeProductoService.agregarProducto(nuevoProducto);
        return ResponseEntity.ok(creado);
    }

    // Modificar Producto
    @PutMapping("/{id}")
    public ResponseEntity<Producto> modificarProducto(@PathVariable int id, @RequestBody Producto producto) {
        try {
            Producto actualizado = gestiondeProductoService.modificarProducto(id, producto);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar Producto
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable int id) {
        try {
            gestiondeProductoService.eliminarProductoPorId(id);
            return ResponseEntity.ok("Producto eliminado.");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
