package com.ecomarket.Assemblers;


import com.ecomarket.controller.GestiondeProductoController;
import com.ecomarket.model.GestiondeProducto;
import com.ecomarket.model.Producto;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class GestiondeProductoAssembler implements RepresentationModelAssembler<GestiondeProducto, EntityModel<GestiondeProducto>>{

    @Override
    public EntityModel<GestiondeProducto> toModel(GestiondeProducto gestiondeProducto) {
        return EntityModel.of(gestiondeProducto,
                linkTo(methodOn(GestiondeProductoController.class).listarProductos()).withRel("productos"),
                linkTo(methodOn(GestiondeProductoController.class).modificarProducto(gestiondeProducto.getId(), (Producto) gestiondeProducto)).withRel("Modificar"),
                linkTo(methodOn(GestiondeProductoController.class).eliminarProducto(gestiondeProducto.getId())).withRel("Eliminar"));
    }
}
