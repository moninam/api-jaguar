package com.uady.apijaguar.service;

import java.util.List;

import com.uady.apijaguar.model.Componente;
import com.uady.apijaguar.repository.ComponenteRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponenteService {
    //Repository
    @Autowired
    private ComponenteRepository componenteRepository;

    //Variables
    private static final Logger LOGGER = LoggerFactory.getLogger(ComponenteService.class);

    public List<Componente> getComponentes(){
        return componenteRepository.findAll();
    }
}
