package com.uady.apijaguar.repository;

import com.uady.apijaguar.model.Animacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimacionRepository extends JpaRepository<Animacion, Integer> {
    
}
