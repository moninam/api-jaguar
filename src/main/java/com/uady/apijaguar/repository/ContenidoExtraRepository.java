package com.uady.apijaguar.repository;

import com.uady.apijaguar.model.ContenidoExtra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContenidoExtraRepository extends JpaRepository<ContenidoExtra,Integer> {
    
}
