package com.ecomarket.Assemblers;



import com.ecomarket.controller.ProovedoresController;
import com.ecomarket.model.Proovedores;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ProovedoresAssembler implements RepresentationModelAssembler<Proovedores, EntityModel<Proovedores>> {

    @Override
    public EntityModel<Proovedores> toModel(Proovedores proovedores) {
        return EntityModel.of(proovedores,
                linkTo(methodOn(ProovedoresController.class).getProovedores()).withSelfRel(),
                linkTo(methodOn(Proovedores.class).getId()).withRel("suppliers")
        );
    }
}
