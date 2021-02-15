package com.uady.apijaguar.repository;

import com.uady.apijaguar.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario,Integer> {
    
}
