package com.ecomarket.Assemblers;

import com.ecomarket.controller.EnvioController;
import com.ecomarket.model.Envio;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class EnvioAssembler  implements RepresentationModelAssembler<Envio, EntityModel<Envio>>{
@Override
public EntityModel<Envio> toModel(Envio Envio) {
    return EntityModel.of(Envio,
            linkTo(methodOn(EnvioController.class).getEnvioById(Envio.getId())).withSelfRel(),
            linkTo(methodOn(EnvioController.class).getEnvio()).withRel("gestionEnvio"),
            linkTo(methodOn(EnvioController.class).getEnvioById(Envio.getId())).withRel("PUT"),
            linkTo(methodOn(EnvioController.class).getEnvioById(Envio.getId())).withRel("DELETE")
    );
}
}
