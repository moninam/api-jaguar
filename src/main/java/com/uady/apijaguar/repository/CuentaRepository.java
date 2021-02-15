package com.uady.apijaguar.repository;

import com.uady.apijaguar.model.Cuenta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
    
}
