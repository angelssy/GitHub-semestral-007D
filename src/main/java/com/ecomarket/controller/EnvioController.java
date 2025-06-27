package com.ecomarket.controller;
import com.ecomarket.model.Producto;
import com.ecomarket.model.Envio;
import com.ecomarket.service.ProductoService;
import com.ecomarket.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/envios")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @GetMapping
    public String getEnvio(){
        return envioService.listarEnvio();
    }

    @PostMapping
    public String postEnvio(@RequestBody Envio envio){
        return envioService.agregarEnvio(envio);
    }

    @GetMapping("/{id}")
    public String getEnvioById(@PathVariable int id){
        return envioService.obtenerEnvioPorId(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEnvioById(@PathVariable int id){
        return envioService.eliminarEnvio(id);
    }

    @PutMapping("/{id}")
    public String putEnvioById(@PathVariable int id, @RequestBody Envio envio){
        return envioService.actualizarEnvio(id,envio);
    }

}
