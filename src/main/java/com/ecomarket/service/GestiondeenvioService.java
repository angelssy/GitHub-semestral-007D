package com.ecomarket.service;


import com.ecomarket.model.Gestiondeenvio;
import com.ecomarket.repository.GestiondeenvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestiondeenvioService {
    @Autowired
    GestiondeenvioRepository gestiondeenvioRepository;

    public String agregarGestiondeenvio(Gestiondeenvio gestiondeenvio) {
        gestiondeenvioRepository.save(gestiondeenvio);
        return "Se ha agregado el envio del paquete por el  id: "+gestiondeenvio.getId();
    }

    public String listarGestionEnvio(){
        String output="";
        for(Gestiondeenvio gestiondeenvio:gestiondeenvioRepository.findAll()){
            output+="ID envio: "+gestiondeenvio.getId()+"\n";
            output+="Nombre envio: "+gestiondeenvio.getGestionName()+"\n";
            output+="Email envio: "+gestiondeenvio.getGestionEmail()+"\n";
            output+="Patente envio: "+gestiondeenvio.getGestionPatente()+"\n";
        }

        if (output.isEmpty()){
            return "No hay envios en ecomarket";

        }else {
            return output;
        }
    }
    public String obtenerGestiondeenvioPorId(int id){
        String output="";
        if (gestiondeenvioRepository.existsById(id)){
            Gestiondeenvio gestiondeenvio=gestiondeenvioRepository.findById(id).get();
            output+="ID envio: "+gestiondeenvio.getId()+"\n";
            output+="Nombre envio: "+gestiondeenvio.getGestionName()+"\n";
            output+="Email envio: "+gestiondeenvio.getGestionEmail()+"\n";
            output+="Patente envio: "+gestiondeenvio.getGestionPatente()+"\n";
            return output;
        }else{
            return "No existe un envio en ecomarket con ese id";
        }
    }

    public String eliminarGestiondeenvio(int id){
        if (gestiondeenvioRepository.existsById(id)){
            gestiondeenvioRepository.deleteById(id);
            return "Se ha eliminado el envio con id: "+id;
        }else{
            return "No existe un envio con ese id";
        }
    }

    public String actualizarGestionEnvio(int id, Gestiondeenvio gestiondeenvio){
        if (gestiondeenvioRepository.existsById(id)){
            Gestiondeenvio buscado=gestiondeenvioRepository.findById(id).get();
            buscado.setGestionName(gestiondeenvio.getGestionName());
            buscado.setGestionEmail(gestiondeenvio.getGestionEmail());
            buscado.setGestionPatente(gestiondeenvio.getGestionPatente());
            gestiondeenvioRepository.save(buscado);
            return "Se ha actualizado el envio con id: "+id;
        }else {
            return "No existe un envio con ese id";
        }
    }

}
