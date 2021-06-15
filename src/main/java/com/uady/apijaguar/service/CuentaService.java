package com.uady.apijaguar.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import com.uady.apijaguar.exception.NotFoundException;
import com.uady.apijaguar.exception.OperationErrorException;
import com.uady.apijaguar.model.Cuenta;
import com.uady.apijaguar.repository.CuentaRepository;
import com.uady.apijaguar.util.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
@Transactional
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

    public Optional<Cuenta> getByAlias(String alias){
        return cuentaRepository.findByAlias(alias);
    }
    public Optional<Cuenta> getByEmail(String email){
        return cuentaRepository.findByEmail(email);
    }
    public boolean existsByAlias(String alias){
        return cuentaRepository.existsByAlias(alias);
    }

    public boolean existsByEmail(String email){
        return cuentaRepository.existsByEmail(email);
    }

    public boolean existsByIdCuenta(Integer idCuenta){
        return cuentaRepository.existsById(idCuenta);
    }

    public void save(Cuenta cuenta){
        cuentaRepository.save(cuenta);
    }

    public void delete(Cuenta cuenta){
        try{
            cuentaRepository.delete(cuenta);
        }catch(Exception e){
            logger.info(e.getMessage());
            throw new OperationErrorException(Constantes.ACCOUNT_ERROR);
        }
    }

    

}
