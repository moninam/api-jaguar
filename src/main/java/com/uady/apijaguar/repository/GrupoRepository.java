package com.uady.apijaguar.repository;

import java.util.List;

import com.uady.apijaguar.model.Grupo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Integer> {
    @Query("SELECT g from Grupo g WHERE g.museo.idMuseo = ?1")
    public List<Grupo> getGruposByIdMuseo(Integer idMuseo);
}
