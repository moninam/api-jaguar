package com.uady.apijaguar.service;

import java.util.ArrayList;
import java.util.List;

import com.uady.apijaguar.exception.InvalidOperationException;
import com.uady.apijaguar.model.Grupo;
import com.uady.apijaguar.model.GrupoModelo;
import com.uady.apijaguar.model.Marcador;
import com.uady.apijaguar.repository.GrupoModeloRepository;
import com.uady.apijaguar.repository.GrupoRepository;
import com.uady.apijaguar.repository.MarcadorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class GrupoService {
    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private GrupoModeloRepository grupoModeloRepository;

    @Autowired
    private MarcadorRepository marcadorRepository;


    private static final Logger LOGGER = LoggerFactory.getLogger(GrupoService.class);

    public List<Grupo> getGruposByIdMuseo(Integer idMuseo){
        try{
            List<Grupo> grupos = new ArrayList<>();

            grupos = grupoRepository.getGruposByIdMuseo(idMuseo);

            return grupos;
        }catch(Exception e){
            LOGGER.error("ERROR: {}", e.getMessage());
            throw new InvalidOperationException("Ocurrio un error al realizar la operación");
        }
    }

    public List<GrupoModelo> getModelosByGrupo(Integer idGrupo){

        try{
            List<GrupoModelo> grupos = new ArrayList<>();

            grupos = grupoModeloRepository.getModelosByIdGrupo(idGrupo);

            return grupos;
        }catch (Exception e){
            LOGGER.error("ERROR: {}", e.getMessage());
            throw new InvalidOperationException("Ocurrio un error al realizar la operación");
        }
    }

    public List<Marcador> getMarcadores(){
        return marcadorRepository.findAll();
    }



}
