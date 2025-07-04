package com.ecomarket.controller;

import com.ecomarket.model.Proovedores;
import com.ecomarket.service.ProovedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProovedoresController {

    @Autowired
    private ProovedoresService proovedoresService;

    @GetMapping
    public String getProovedores() {
        return ProovedoresService.listarProovedores();
    }

    @PostMapping
    public String postProovedores(@RequestBody Proovedores proovedores) {
        return proovedoresService.agregarProovedor(proovedores);
    }

    @GetMapping("/{id}")
    public String getProovedoresById(@PathVariable int id) {
        return proovedoresService.obtenerProovedor(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProovedoresById(@PathVariable int id) {
        return proovedoresService.eliminarProovedor(id);
    }

    @PutMapping("/{id}")
    public String putProovedoresById(@PathVariable int id, @RequestBody Proovedores proovedores) {
        return proovedoresService.actualizarProovedor(id, proovedores);
    }
}
