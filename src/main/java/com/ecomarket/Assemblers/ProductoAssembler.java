package com.ecomarket.Assemblers;


import com.ecomarket.controller.ProductoController;
import com.ecomarket.model.GestiondeProducto;
import com.ecomarket.model.Producto;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
public class ProductoAssembler implements RepresentationModelAssembler<Producto, EntityModel<Producto>>{

    @Override
    public EntityModel<Producto> toModel(Producto producto) {
        return EntityModel.of(producto,
                linkTo(methodOn(Producto.class).getPrice()).withSelfRel(),
                linkTo(methodOn(Producto.class).getStock()).withRel("stock producto")
        );
    }
}
