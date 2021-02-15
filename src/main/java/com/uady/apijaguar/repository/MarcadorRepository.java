package com.uady.apijaguar.repository;

import com.uady.apijaguar.model.Marcador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcadorRepository extends JpaRepository<Marcador, Integer>{
    
}
