package com.uady.apijaguar.repository;

import java.util.Optional;

import com.uady.apijaguar.model.TargetComponente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetComponenteRepository extends JpaRepository<TargetComponente,Integer> {
    Optional<TargetComponente> findByIdComponente(Integer idComponente);

}
