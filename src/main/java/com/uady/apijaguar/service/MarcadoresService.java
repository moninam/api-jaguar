package com.uady.apijaguar.service;

import com.uady.apijaguar.repository.MarcadorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import com.uady.apijaguar.exception.InvalidOperationException;
import com.uady.apijaguar.model.Marcador;

@Service
public class MarcadoresService {
    @Autowired
    private MarcadorRepository marcadorRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(GrupoService.class);

    public List<Marcador> getMarcadores() {
        try {
            return marcadorRepository.findAll();
        } catch (Exception e) {
            LOGGER.error("ERROR: {}", e.getMessage());
            throw new InvalidOperationException("Ocurrio un error al realizar la operación");
        }
    }
}
