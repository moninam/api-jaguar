package com.uady.apijaguar.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import com.uady.apijaguar.exception.NotFoundException;
import com.uady.apijaguar.model.Cuenta;
import com.uady.apijaguar.repository.CuentaRepository;
import com.uady.apijaguar.util.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class CuentaService {
    @Autowired
    CuentaRepository cuentaRepository;

    private Logger logger = LogManager.getLogger(this.getClass());

    public Cuenta findCuenta(Integer id){
        try{
            Optional<Cuenta> cuenta = cuentaRepository.findById(id);

            if(cuenta.isPresent()){
                return cuenta.get();
            }
           throw new NotFoundException(Constantes.ENTITY_NOT_FOUND);
           
        } catch(NoSuchElementException exc){
            throw new NotFoundException(Constantes.ENTITY_NOT_FOUND);
        }
    }


}
