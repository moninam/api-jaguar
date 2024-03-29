package com.uady.apijaguar.repository;

import java.util.Optional;

import com.uady.apijaguar.enums.RolNombre;
import com.uady.apijaguar.model.Rol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
   Optional<Rol> findByRolNombre(RolNombre rolNombre);
}