package com.uady.apijaguar.service;

import java.util.List;
import java.util.Optional;

import com.uady.apijaguar.exception.NotFoundException;
import com.uady.apijaguar.exception.OperationErrorException;
import com.uady.apijaguar.model.Componente;
import com.uady.apijaguar.repository.ComponenteRepository;
import com.uady.apijaguar.util.Constantes;

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

    public void save(Componente componente){
        try{
            componenteRepository.save(componente);
        }catch(Exception e){
            LOGGER.error(e.getMessage());
            throw new OperationErrorException(Constantes.COMPONENTE_ERROR_R);
        }
    }

    public Componente saveComponente(Componente componente){
        try{
            Componente f = componenteRepository.save(componente);
            return f;
        }catch(Exception e){
            LOGGER.error(e.getMessage());
            throw new OperationErrorException(Constantes.COMPONENTE_ERROR_R);
        }
    }

    public Componente findById(Integer id){
        Optional<Componente> cOpt = componenteRepository.findById(id);

        if (!cOpt.isPresent()){
            throw new NotFoundException(Constantes.COMPONENTE_NOT_FOUND);
        }
        return cOpt.get();
    }
    public void deleteComponente(Componente c){
        try{
            componenteRepository.delete(c);
        }catch(Exception e){
            LOGGER.error(e.getMessage());
            throw new OperationErrorException(Constantes.COMPONENTE_DELETE_ERROR);
        }
    }
    public Optional<Componente> getById(Integer id){
        return componenteRepository.findById(id);
    }
}
