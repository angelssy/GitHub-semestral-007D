package com.ecomarket.service;

import com.ecomarket.model.Proovedores;
import com.ecomarket.repository.ProovedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProovedoresService {

    @Autowired
    static ProovedoresRepository proovedoresRepository;

    public String agregarProovedor(Proovedores proovedor) {
        proovedoresRepository.save(proovedor);
        return "Se ha agregado el  con id: "+proovedor.getId();

    }
    public static String listarProovedores() {
        String output="";
        for(Proovedores proovedores:proovedoresRepository.findAll()){
            output+="ID proveedor: "+proovedores.getId()+"\n";
            output+="Nombre proveedor: "+proovedores.getSupplierName()+"\n";
            output+="Email proveedor: "+proovedores.getSupplierEmail()+"\n";
        }

        if (output.isEmpty()){
            return "No hay proveedores";

        }else {
            return output;
        }
    }

    public String obtenerProovedor(int id){
        String output="";
        if (proovedoresRepository.existsById(id)){
            Proovedores proovedores=proovedoresRepository.findById(id).get();
            output+="ID proveedor: "+proovedores.getId()+"\n";
            output+="Nombre proveedor: "+proovedores.getSupplierName()+"\n";
            output+="Email proveedor: "+proovedores.getSupplierEmail()+"\n";
            return output;
        }else{
            return "No existe un proveedor con ese id";
        }
    }
    public String eliminarProovedor(int id){
        if (proovedoresRepository.existsById(id)){
            proovedoresRepository.deleteById(id);
            return "Se ha eliminado el proveedor con id: "+id;
        }else{
            return "No existe un proveedor con ese id";
        }
    }

    public String actualizarProovedor(int id, Proovedores proovedor) {
        if (proovedoresRepository.existsById(id)){
            Proovedores buscado=proovedoresRepository.findById(id).get();
            buscado.setSupplierName(proovedor.getSupplierName());
            buscado.setSupplierEmail(proovedor.getSupplierEmail());
            proovedoresRepository.save(buscado);
            return "Se ha actualizado el proveedor con id: "+id;
        }else {
            return "No existe un proveedor con ese id";
        }
    }
}
