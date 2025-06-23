package com.ecomarket.controller;

import com.ecomarket.model.Gestiondeenvio;
import com.ecomarket.model.Envio;
import com.ecomarket.service.GestiondeenvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gestiondeenvios")
public class GestiondeenvioController {

    @Autowired
    private GestiondeenvioService gestiondeenvioService;

    @GetMapping
    public String getGestiondeenvio(){
        return gestiondeenvioService.listarGestionEnvio();
    }

    @PostMapping
    public String postShipping(@RequestBody Gestiondeenvio gestiondeenvio){
        return gestiondeenvioService.agregarGestiondeenvio(gestiondeenvio);
    }
    @GetMapping("/{id}")
    public String getGestiondeenvioById(@PathVariable int id){
        return gestiondeenvioService.obtenerGestiondeenvioPorId(id);
    }

    @DeleteMapping("/{id}")
    public String deleteGestiondeenvioById(@PathVariable int id){
        return gestiondeenvioService.eliminarGestiondeenvio(id);
    }

    @PutMapping("/{id}")
    public String putGestiondeenvioById(@PathVariable int id, @RequestBody Gestiondeenvio gestiondeenvio){
        return gestiondeenvioService.actualizarGestionEnvio(id,gestiondeenvio);
    }
}
