package com.uady.apijaguar.repository;

import com.uady.apijaguar.model.Componente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponenteRepository extends JpaRepository<Componente, Integer> {
    
}
