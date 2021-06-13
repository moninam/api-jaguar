package com.uady.apijaguar.repository;

import java.util.Optional;

import com.uady.apijaguar.model.Cuenta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
    Optional<Cuenta> findByAlias(String alias);
    Optional<Cuenta> findByEmail(String email);
    boolean existsByAlias(String alias);
    boolean existsByEmail(String email);
}
