package com.uady.apijaguar.repository;

import java.util.List;

import com.uady.apijaguar.model.Grupo;
import com.uady.apijaguar.model.Museo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoRepository extends JpaRepository<Grupo, Integer> {
    List<Grupo> findByMuseo(Museo museo);
}
