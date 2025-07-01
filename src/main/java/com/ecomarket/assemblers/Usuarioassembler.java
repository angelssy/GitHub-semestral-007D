package com.ecomarket.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.ecomarket.model.Usuario;
import com.ecomarket.model.hateoas.Usuariomodel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class UsuarioAssembler extends RepresentationModelAssemblerSupport<Usuario, UsuarioModel> {

    public UsuarioAssembler() {
        super(UsuarioController.class, UsuarioModel.class);
    }

    @Override
    public UsuarioModel toModel(Usuario entity) {
        UsuarioModel model = new UsuarioModel();
        model.setId(entity.getId());
        model.setNombre(entity.getNombre());
        // ... otros campos

        model.add(linkTo(
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
