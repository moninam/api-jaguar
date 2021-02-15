package com.uady.apijaguar.repository;

import com.uady.apijaguar.model.Museo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuseoRepository extends JpaRepository <Museo, Integer>{
    
}
