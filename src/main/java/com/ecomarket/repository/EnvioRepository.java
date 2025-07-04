package com.ecomarket.repository;

import com.ecomarket.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EnvioRepository extends JpaRepository<Envio, Integer>{
}
