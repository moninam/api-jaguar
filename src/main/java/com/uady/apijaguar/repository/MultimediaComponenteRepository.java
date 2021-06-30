package com.uady.apijaguar.repository;

import java.util.List;
import java.util.Optional;

import com.uady.apijaguar.model.Multimedia;
import com.uady.apijaguar.model.MultimediaComponente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultimediaComponenteRepository extends JpaRepository<MultimediaComponente,Integer>{
    Optional<MultimediaComponente> findByIdComponente(Integer idComponente);
    List<MultimediaComponente> findByIdMultimedia(Integer idMultimedia);
}
