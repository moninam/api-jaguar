package com.uady.apijaguar.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.uady.apijaguar.model.GrupoModelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface GrupoModeloRepository extends JpaRepository<GrupoModelo, Integer> {
    @Query("SELECT g from GrupoModelo g WHERE g.grupo.idGrupo = ?1")
    public List<GrupoModelo> getModelosByIdGrupo(Integer idGrupo);
}
