package com.uady.apijaguar.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.uady.apijaguar.exception.NotFoundException;
import com.uady.apijaguar.exception.OperationErrorException;
import com.uady.apijaguar.model.Componente;
import com.uady.apijaguar.model.Grupo;
import com.uady.apijaguar.model.Museo;
import com.uady.apijaguar.repository.GrupoRepository;
import com.uady.apijaguar.util.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class GrupoService {
    @Autowired
    GrupoRepository grupoRepository;

    @Autowired
    MuseoService museoService;

    private Logger logger = LogManager.getLogger(this.getClass());

    public List<Grupo> getGruposByIdMuseo(Integer idMuseo){

        Museo museo = museoService.getById(idMuseo);

        if (museo == null){
            throw new NotFoundException(Constantes.MUSEO_NOT_EXIST);
        }

        List<Grupo> grupos = grupoRepository.findByMuseo(museo);

        return grupos;
    }

    public Set<Componente> getComponentesByIdGrupo(Integer idGrupo){
        Optional<Grupo> grupo = grupoRepository.findById(idGrupo);

        if (!grupo.isPresent()){
            throw new NotFoundException(Constantes.GRUPO_NOT_EXIST);
        }
        Grupo grupoFinal = grupo.get();

        Set<Componente> componentes = grupoFinal.getComponentes();

        return componentes;
    }

    public void save(Grupo grupo){
        try{
            grupoRepository.save(grupo);
        }catch(Exception e){
            logger.error(e.getMessage());
            throw new OperationErrorException(Constantes.GRUPO_ERROR_R);
        }
    }
}
