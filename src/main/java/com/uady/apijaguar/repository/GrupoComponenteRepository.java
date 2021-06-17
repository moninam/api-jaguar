package com.uady.apijaguar.repository;

import java.util.Optional;

import com.uady.apijaguar.model.GrupoComponente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoComponenteRepository extends JpaRepository<GrupoComponente,Integer> {
    Optional<GrupoComponente> findByIdComponente(Integer idComponente);
}
