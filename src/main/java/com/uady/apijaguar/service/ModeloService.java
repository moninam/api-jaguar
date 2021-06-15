package com.uady.apijaguar.service;

import java.util.Optional;

import com.uady.apijaguar.exception.NotFoundException;
import com.uady.apijaguar.model.Modelo;
import com.uady.apijaguar.repository.ModeloRepository;
import com.uady.apijaguar.util.Constantes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeloService {
    @Autowired
    ModeloRepository modeloRepository;
    
    private Logger logger = LogManager.getLogger(this.getClass());

    public Modelo findById(Integer id){
        Optional<Modelo> mOpt = modeloRepository.findById(id);

        if (!mOpt.isPresent()){
            throw new NotFoundException(Constantes.MODEL_NOT_FOUND);
        }

        return mOpt.get();
    }
}
