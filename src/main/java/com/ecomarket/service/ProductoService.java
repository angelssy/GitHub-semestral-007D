package com.ecomarket.service;

import com.ecomarket.model.Producto;
import com.ecomarket.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public String agregarProducto(Producto producto){
        productoRepository.save(producto);
        return "Se ha agregado el producto con id: "+producto.getId();
    }

    public String listarProductos(){
        String output="";
        for(Producto producto:productoRepository.findAll()){
            output+="ID producto: "+producto.getId()+"\n";
            output+="Nombre producto: "+producto.getName()+"\n";
            output+="Descripcion producto: "+producto.getDescription()+"\n";
            output+="Stock producto: "+producto.getStock()+"\n";
        }

        if (output.isEmpty()){
            return "No hay productos";

        }else {
            return output;
        }
    }

    public String obtenerProductoPorId(int id){
        String output="";
        if (productoRepository.existsById(id)){
            Producto producto=productoRepository.findById(id).get();
            output+="ID producto: "+producto.getId()+"\n";
            output+="Nombre producto: "+producto.getName()+"\n";
            output+="Descripcion producto: "+producto.getDescription()+"\n";
            output+="Stock producto: "+producto.getStock()+"\n";
            return output;
        }else{
            return "No existe un producto con ese id";
        }
    }

}
