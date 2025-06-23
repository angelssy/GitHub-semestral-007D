package com.ecomarket.controller;

import com.ecomarket.model.Producto;
import com.ecomarket.service.GestiondeProductoService;
import com.ecomarket.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private GestiondeProductoService gestiondeProductoService;

    @GetMapping
    public String getProducto() {return productoService.listarProductos();}


    @GetMapping("/{id}")
    public String getProductoById(@PathVariable int id) {
        return productoService.obtenerProductoPorId(id);
    }

}
