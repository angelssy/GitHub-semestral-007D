package com.ecomarket.model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Producto extends GestiondeProducto{

    private String name;
    private String description;
    private double price;

    public Producto(int i, String mouse, String desc2, double v, int i1) {
    }
}
