package com.uady.apijaguar.repository;

import com.uady.apijaguar.model.Multimedia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultimediaRepository extends JpaRepository<Multimedia, Integer>{
    
}
