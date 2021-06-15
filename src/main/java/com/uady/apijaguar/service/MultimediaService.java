package com.uady.apijaguar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.uady.apijaguar.exception.NotFoundException;
import com.uady.apijaguar.model.Multimedia;
import com.uady.apijaguar.repository.MultimediaRepository;
import com.uady.apijaguar.util.Constantes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class MultimediaService {
    @Autowired
    MultimediaRepository multimediaRepository;

    private Logger logger = LogManager.getLogger(this.getClass());

    public Multimedia findById(Integer id){
        Optional<Multimedia> mult = multimediaRepository.findById(id);

        if (!mult.isPresent()) {
            throw new NotFoundException(Constantes.MULT_NOT_FOUND);
        }
        return mult.get();
    }
}
