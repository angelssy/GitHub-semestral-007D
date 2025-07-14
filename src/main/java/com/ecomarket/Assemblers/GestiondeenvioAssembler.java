package com.ecomarket.Assemblers;

import com.ecomarket.controller.GestiondeenvioController;
import com.ecomarket.model.Gestiondeenvio;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class GestiondeenvioAssembler implements RepresentationModelAssembler<Gestiondeenvio, EntityModel<Gestiondeenvio>>{

    @Override
    public EntityModel<Gestiondeenvio> toModel(Gestiondeenvio gestiondeenvio) {
        return EntityModel.of(gestiondeenvio,
                linkTo(methodOn(Gestiondeenvio.class).getGestionEmail()).withSelfRel(),
                linkTo(methodOn(Gestiondeenvio.class).getGestionEmail()).withRel("gestionEnvioemail"),
                linkTo(methodOn(Gestiondeenvio.class).getGestionEmail()).withRel("emailcorrecto")

        );
    }
}
