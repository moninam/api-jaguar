package com.uady.apijaguar.repository;

import com.uady.apijaguar.model.Target;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetRepository extends JpaRepository<Target, Integer> {
    
}
