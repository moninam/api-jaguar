package com.uady.apijaguar.repository;

import java.util.List;
import java.util.Optional;

import com.uady.apijaguar.model.ModeloComponente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloComponenteRepository extends JpaRepository<ModeloComponente,Integer> {
    Optional<ModeloComponente> findByIdComponente(Integer idComponente);
    List<ModeloComponente> findByIdModelo(Integer idModelo);
}
