package com.ecomarket.repository;

import com.ecomarket.model.Proovedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProovedoresRepository extends JpaRepository<Proovedores, Integer> {
}
