package com.ecomarket.repository;

import com.ecomarket.model.GestiondeProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GestiondeProductoRepository extends JpaRepository<GestiondeProducto, Integer> {
}
