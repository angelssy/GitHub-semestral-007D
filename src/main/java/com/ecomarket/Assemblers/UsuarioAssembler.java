package com.ecomarket.Assemblers;

import com.ecomarket.controller.UsuarioController;
import com.ecomarket.model.Usuario;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class UsuarioAssembler implements RepresentationModelAssembler<Usuario, EntityModel<Usuario>>{

    @Override

    public EntityModel<Usuario> toModel(Usuario usuario) {
        return EntityModel.of(usuario,
                linkTo(methodOn(UsuarioController.class).getUserById(usuario.getId())).withSelfRel(),
                linkTo(methodOn(UsuarioController.class).getUsers()).withRel("users"));
    }
}
