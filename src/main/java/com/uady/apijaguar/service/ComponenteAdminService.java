package com.uady.apijaguar.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


import com.uady.apijaguar.dto.ComponenteRequestDto;
import com.uady.apijaguar.dto.ComponenteUpdateDto;
import com.uady.apijaguar.enums.ComponentType;
import com.uady.apijaguar.exception.NotFoundException;
import com.uady.apijaguar.exception.OperationErrorException;
import com.uady.apijaguar.model.Componente;
import com.uady.apijaguar.model.Grupo;
import com.uady.apijaguar.model.GrupoComponente;
import com.uady.apijaguar.model.Modelo;
import com.uady.apijaguar.model.ModeloComponente;
import com.uady.apijaguar.model.Multimedia;
import com.uady.apijaguar.model.MultimediaComponente;
import com.uady.apijaguar.model.Museo;
import com.uady.apijaguar.model.Target;
import com.uady.apijaguar.model.TargetComponente;
import com.uady.apijaguar.repository.ComponenteRepository;
import com.uady.apijaguar.util.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
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

    @Autowired
    JoinComponentService joinComponentService;

    private Logger logger = LogManager.getLogger(this.getClass());

    public Set<Componente> getComponentesByIdMuseo(Integer id){
        Optional<Museo> museo = museoService.getById(id);

        if (!museo.isPresent()){
            throw new NotFoundException(Constantes.MUSEO_NOT_FOUND);
        }
        Set<Componente> componentes = museo.get().getComponentes();

        return componentes;
    }
    //FUNCIONES PARA AGREGAR UN NUEVO COMPONENTE
    @Transactional(rollbackFor = Exception.class)
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
    
    @Transactional(rollbackFor = Exception.class)
    public Componente updateComponente(ComponenteUpdateDto request, Integer id){
        Optional<Componente> componente = componenteService.getById(id);

        if (!componente.isPresent()){
            throw new NotFoundException(Constantes.COMPONENTE_NOT_FOUND);
        }
       
        try{
            
            //Generar componente y guardarlo
            Componente temporal = componente.get();
            verifyElement(temporal, request.getTipoComponente());
            temporal.setNombre(request.getNombre());
            temporal.setUrlImagen(request.getUrlImagen());
            temporal.setDescription(request.getDescripcion());
            temporal.isTarget(request.getHasTarget());
            temporal.setComponentType(request.getTipoComponente());
            temporal.isDescription(request.getHasDescription());

            Integer idComponente = temporal.getIdComponente();

            
            updateElement(idComponente,request.getIdElemento(),request.getTipoComponente());
            updateGrupo(idComponente, request.getIdGrupo());
            updateTarget(idComponente, request.getIdMarcador());
            
            componenteService.save(temporal);

        
            return temporal;
        } catch (Exception e){
            logger.error(e.getMessage());
            throw new OperationErrorException(Constantes.ACCOUNT_ERROR);
        }

    }
    private void updateGrupo(Integer idComponente, Integer idGrupoN){
        Componente componente = componenteService.findById(idComponente);
        Optional<GrupoComponente> grupoC = joinComponentService.getGrupoByIdComponente(idComponente);

        Optional<Grupo> grupo = grupoService.getGrupoById(idGrupoN);

        if(grupo.isPresent()){
            if (!grupoC.isPresent()){
                Grupo temp = grupo.get();
                temp.addComponente(componente);
                componenteService.save(componente);
            } else if (!(grupoC.get().getIdGrupo().equals(idGrupoN))){
                
                GrupoComponente grupoComponente = grupoC.get();

                grupoComponente.setIdGrupo(grupo.get().getIdGrupo());
                joinComponentService.saveGrupo(grupoComponente);
                
               
            }
        } else if (grupoC.isPresent()){
            if (!(grupoC.get().getIdGrupo().equals(idGrupoN)) && !(idGrupoN.equals(-1))){
                logger.error("El grupo no existe");
                throw new NotFoundException(Constantes.GRUPO_NOT_EXIST);
            } else if (idGrupoN.equals(-1)){
                GrupoComponente gC = grupoC.get();
                Optional<Grupo> g = grupoService.getGrupoById(gC.getIdGrupo());
                if (g.isPresent()){
                    Grupo grupoT = g.get();
                    grupoT.removeComponente(componente);
                }
            }
        }
    }
    private void updateElement(Integer idComponent, Integer idElement, ComponentType type){
        Componente componente = componenteService.findById(idComponent);
        Optional<ModeloComponente> mComponente = joinComponentService.getModeloByIdComponente(idComponent);
        Optional<MultimediaComponente> multComponente = joinComponentService.getMultimediaByIdComponente(idComponent);
        
        if (type.equals(ComponentType.MODELO)){
            Modelo modelo = modeloService.findById(idElement);
            if (!mComponente.isPresent() || 
                (!(mComponente.get().getIdModelo().equals(idElement))) ){

                componente.setModelo(modelo);
                componenteService.save(componente);
            }
        } else if (type.equals(ComponentType.IMAGEN) || type.equals(ComponentType.VIDEO)){
            Multimedia mult = multimediaService.findById(idElement);
            if (!multComponente.isPresent() || 
                (!(multComponente.get().getIdMultimedia().equals(idElement))) ){
               
                componente.setMultimedia(mult);
                componenteService.save(componente);
            }
        } 
    }
    private void updateTarget(Integer idComponente, Integer idTargetN){
        Componente componente = componenteService.findById(idComponente);
        Optional<TargetComponente> targetC = joinComponentService.getTargetByIdComponente(idComponente);

        Optional<Target> target = targetService.findById(idTargetN);

        if(target.isPresent()){
            if (!targetC.isPresent() ||
                (!(targetC.get().getIdTarget()).equals(idTargetN))){
               Target temp = target.get();
                componente.setTarget(temp);
                componenteService.save(componente);
            } 
        } else if (targetC.isPresent()){
            if (!(targetC.get().getIdTarget().equals(idTargetN)) && !(idTargetN.equals(-1))){
                logger.error("Target no existe");
                throw new NotFoundException(Constantes.TARGET_DO_NOT_EXIST);
            } else if(idTargetN.equals(-1)){
                componente.setTarget(null);
            }
        }
    }
    
    private void verifyElement(Componente componente,ComponentType type){
        if (!componente.getComponentType().equals(type)){
            logger.info("PASA JAJAJAJ");
            if (componente.getComponentType().equals(ComponentType.MODELO)){
                logger.info("PASA MODELOJ");
                componente.setModelo(null);
            } else if (componente.getComponentType().equals(ComponentType.IMAGEN) || componente.getComponentType().equals(ComponentType.VIDEO)){
                logger.info("PASA MULTIMEDIA");
                componente.setMultimedia(null);
            } 
        }
        componenteService.save(componente);
    }

}
