package com.ecomarket.service;

import com.ecomarket.model.Envio;
import com.ecomarket.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnvioService {

    @Autowired
    EnvioRepository envioRepository;

    public String agregarEnvio(Envio envio){
        envioRepository.save(envio);
        return "Se ha agregado el envio con id: "+envio.getId();
    }

    public String listarEnvio(){
        String output="";
        for(Envio envio:envioRepository.findAll()){
            output+="ID envio: "+envio.getId()+"\n";
            output+="Nombre envio: "+envio.getEnvioName()+"\n";
            output+="Email envio: "+envio.getEnvioEmail()+"\n";
            output+="Patente envio: "+envio.getPatente()+"\n";
        }

        if (output.isEmpty()){
            return "No hay envios";

        }else {
            return output;
        }
    }

    public String obtenerEnvioPorId(int id){
        String output="";
        if (envioRepository.existsById(id)){
            Envio envio =envioRepository.findById(id).get();
            output+="ID envio: "+envio.getId()+"\n";
            output+="Nombre envio: "+envio.getEnvioName()+"\n";
            output+="Email envio: "+envio.getEnvioEmail()+"\n";
            output+="Patente envio: "+envio.getPatente()+"\n";
            return output;
        }else{
            return "No existe un envio con ese id";
        }
    }

    public String eliminarEnvio(int id){
        if (envioRepository.existsById(id)){
            envioRepository.deleteById(id);
            return "Se ha eliminado el envio con id: "+id;
        }else{
            return "No existe un envio con ese id";
        }
    }

    public String actualizarEnvio(int id, Envio envio){
        if (envioRepository.existsById(id)){
            Envio buscado=envioRepository.findById(id).get();
            buscado.setEnvioName(envio.getEnvioName());
            buscado.setEnvioEmail(envio.getEnvioEmail());
            buscado.setPatente(envio.getPatente());
            envioRepository.save(buscado);
            return "Se ha actualizado el envio con id: "+id;
        }else {
            return "No existe un envio con ese id";
        }
    }
}
