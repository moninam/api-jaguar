package com.uady.apijaguar.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import com.uady.apijaguar.dto.ComponenteRequestDto;
import com.uady.apijaguar.enums.ComponentType;
import com.uady.apijaguar.exception.NotFoundException;
import com.uady.apijaguar.exception.OperationErrorException;
import com.uady.apijaguar.model.Componente;
import com.uady.apijaguar.model.Grupo;
import com.uady.apijaguar.model.Modelo;
import com.uady.apijaguar.model.Multimedia;
import com.uady.apijaguar.model.Museo;
import com.uady.apijaguar.model.Target;
import com.uady.apijaguar.repository.ComponenteRepository;
import com.uady.apijaguar.util.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
@Transactional
public class ComponenteAdminService {
    @Autowired
    ComponenteRepository componenteRepository;

    @Autowired
    MuseoService museoService;

    @Autowired
    GrupoService grupoService;

    @Autowired
    ComponenteService componenteService;

    @Autowired
    ModeloService modeloService;

    @Autowired
    MultimediaService multimediaService;

    @Autowired
    TargetService targetService;

    private Logger logger = LogManager.getLogger(this.getClass());

    public Set<Componente> getComponentesByIdMuseo(Integer id){
        Optional<Museo> museo = museoService.getById(id);

        if (!museo.isPresent()){
            throw new NotFoundException(Constantes.MUSEO_NOT_FOUND);
        }
        Set<Componente> componentes = museo.get().getComponentes();

        return componentes;
    }
    public Componente createComponente(ComponenteRequestDto request){
        Optional<Museo> museo = museoService.getById(request.getIdMuseo());

        if (!museo.isPresent()){
            throw new NotFoundException(Constantes.MUSEO_NOT_FOUND);
        }
        logger.info("DESCRIPCION: " + request.getHasDescription());
        logger.info("target"+ request.getHasTarget());
        //Generar componente y guardarlo
        Componente componente = new Componente( 
                                request.getNombre(),
                                request.getUrlImagen(),
                                request.getDescripcion(),
                                request.getHasTarget(),
                                request.getTipoComponente(),
                                request.getHasDescription()
                                );
        logger.info("SI PASA WE");
        Componente nuevoC = componenteService.saveComponente(componente);

        Integer idComponente = nuevoC.getIdComponente();
        saveGrupo(idComponente, request.getIdGrupo());
        saveElement(idComponente, request.getIdElemento(), request.getTipoComponente());
        saveTarget(idComponente, request.getIdMarcador());
        Museo mComponent = museo.get();
        mComponent.addComponente(nuevoC);
        return nuevoC;
    }
    private void saveGrupo(Integer idComponent, Integer idGrupo){
        Componente componente = componenteService.findById(idComponent);
        Optional<Grupo> grupo = grupoService.getGrupoById(idGrupo);

        if (grupo.isPresent()){
            Grupo temp = grupo.get();
            temp.addComponente(componente);
            componenteService.save(componente);
        }
    }
    private void saveElement(Integer idComponent, Integer idElement, ComponentType type){
        logger.info("SI PASA ELEMENT");
        Componente componente = componenteService.findById(idComponent);

        if (type.equals(ComponentType.MODELO)){
            Modelo modelo = modeloService.findById(idElement);
            //Guardar la relacion componente-modelo
            componente.setModelo(modelo);
            componenteService.save(componente);
        } else if (type.equals(ComponentType.IMAGEN) || type.equals(ComponentType.VIDEO)){
            logger.info("SI PASA VALIDACION MULT");
            Multimedia mult = multimediaService.findById(idElement);
            componente.setMultimedia(mult);
            componenteService.save(componente);
        } else {
            rollback(componente);
            throw new OperationErrorException(Constantes.COMP_NOT_ELEMENT);
        }
    }
    private void saveTarget(Integer idComponent, Integer idTarget){
        Componente componente = componenteService.findById(idComponent);
        Optional<Target> target = targetService.findById(idTarget);

        if(target.isPresent()){
            componente.setTarget(target.get());
            componenteService.save(componente);
        }
    }
    private void rollback(Componente componente){
    
        if (componente != null){
            try{
                componenteService.deleteComponente(componente);
            }catch(OperationErrorException ex){
                throw new OperationErrorException(Constantes.COMP_ROLLBACK_ERROR);
            }
        }
    }
}
