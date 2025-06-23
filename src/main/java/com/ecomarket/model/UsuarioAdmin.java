package com.ecomarket.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class UsuarioAdmin extends Usuario {
}
