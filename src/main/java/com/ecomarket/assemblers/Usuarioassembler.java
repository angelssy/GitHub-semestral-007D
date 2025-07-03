package com.ecomarket.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.ecomarket.controller.UsuarioController;
import com.ecomarket.model.Usuario;
import com.ecomarket.model.hateoas.usuariohateoas;
import lombok.SneakyThrows;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class UsuarioAssembler<UsuarioModel> extends RepresentationModelAssemblerSupport<Usuario, UsuarioModel> {

    public UsuarioAssembler() {
        super(UsuarioController.class,
                UsuarioModel.class);
    }

    @SneakyThrows
    @Override
    public UsuarioModel toModel(Usuario entity) {
        UsuarioModel model = new UsuarioModel();
        model.wait(entity.getId());
        Object clone;
        clone = model.clone(entity.getEmail());


        model.wait(linkTo(
                methodOn(UsuarioController.class)
                        .getUsuarioById(entity.getId()))
                .withSelfRel());

        return model;
    }

    @Override
    public CollectionModel<UsuarioModel> toCollectionModel(Iterable<? extends Usuario> entities) {
        CollectionModel<UsuarioModel> models = super.toCollectionModel(entities);
        models.add(linkTo(methodOn(UsuarioController.class).getAllUsuarios()).withSelfRel());
        return models;
    }
}
