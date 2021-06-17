package com.uady.apijaguar.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.uady.apijaguar.dto.DeleteDto;
import com.uady.apijaguar.dto.ModeloRequestDto;
import com.uady.apijaguar.dto.ModeloUpdateDto;
import com.uady.apijaguar.exception.InvalidOperationException;
import com.uady.apijaguar.exception.NotFoundException;
import com.uady.apijaguar.model.Componente;
import com.uady.apijaguar.model.Modelo;
import com.uady.apijaguar.model.ModeloComponente;
import com.uady.apijaguar.model.Museo;
import com.uady.apijaguar.repository.ModeloRepository;
import com.uady.apijaguar.util.Constantes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModeloService {
    @Autowired
    ModeloRepository modeloRepository;

    @Autowired
    MuseoService museoService;
    
    @Autowired
    JoinComponentService componentJService;

    @Autowired
    ComponenteService componenteService;
    
    
    private Logger logger = LogManager.getLogger(this.getClass());

    public Modelo findById(Integer id){
        Optional<Modelo> mOpt = modeloRepository.findById(id);

        if (!mOpt.isPresent()){
            throw new NotFoundException(Constantes.MODEL_NOT_FOUND);
        }

        return mOpt.get();
    }
    public Set<Modelo> getModelosByIdMuseo(Integer idMuseo){
        Optional<Museo> m = museoService.getById(idMuseo);

        if (!m.isPresent()){
            throw new NotFoundException(Constantes.MUSEO_NOT_FOUND);
        }
        Museo museo = m.get();
        Set<Modelo> modelos = museo.getModelos();

        return modelos;
    }

    @Transactional(rollbackFor = Exception.class)
    public Modelo createModelo(ModeloRequestDto request){
        Optional<Museo> m = museoService.getById(request.getIdMuseo());

        if (!m.isPresent()){
            throw new NotFoundException(Constantes.MUSEO_NOT_FOUND);
        }
        Museo museo = m.get();

        Modelo modelo = new Modelo(
                        request.getUrlModelo(),
                        request.getNombre(),
                        request.getNombreAnimacion(),
                        request.getHasRotation(),
                        request.getHasMovement(),
                        request.getHasResize(),
                        request.getTexturaPath()
                        );
        Modelo modeloNuevo = modeloRepository.save(modelo);
        museo.addModelo(modeloNuevo);
        museoService.save(museo);
        return modeloNuevo;
    }
    @Transactional(rollbackFor = Exception.class)
    public Modelo updateModelo(ModeloUpdateDto request,Integer idModelo){
        Modelo modelo = findById(idModelo);

        modelo.setUrlModelo(request.getUrlModelo());
        modelo.setNombre(request.getNombre());
        modelo.setNombreAnimacion(request.getNombreAnimacion());
        modelo.isRotation(request.getHasRotation());
        modelo.isMovement(request.getHasMovement());
        modelo.isResize(request.getHasResize());
        modelo.setTexturaPath(request.getTexturaPath());

        Modelo modeloNuevo = modeloRepository.save(modelo);

        return modeloNuevo; 
    }
    @Transactional(rollbackFor = Exception.class)
    public DeleteDto deleteModelo(Integer id, Integer idMuseo){
        Optional<Museo> mOpt = museoService.getById(idMuseo);
        Optional<Modelo> modOpt = modeloRepository.findById(id);

        if(!mOpt.isPresent()){
            throw new NotFoundException(Constantes.MUSEO_NOT_FOUND);
        }
        if (!modOpt.isPresent()){
            throw new NotFoundException(Constantes.MODELO_NOT_FOUND);
        }

        Museo m = mOpt.get();
       
        if(m.containsModel(modOpt.get())){
            m.removeModelo(modOpt.get());
            museoService.save(m);
        }
        List<ModeloComponente> componentes = componentJService.getComponentesByModelo(id);
        if (!componentes.isEmpty()){
            throw new InvalidOperationException(Constantes.MODELO_CANT_DELETE);
        }
        modeloRepository.delete(modOpt.get());

        DeleteDto delete = new DeleteDto(200,Constantes.MODELO_DELETE_SUCCESS);
        
        return delete;
    }

    private void manageComponents(List<ModeloComponente> componentes){
        for(ModeloComponente item: componentes){
            Optional<Componente> c = componenteService.getById(item.getIdComponente());
            if(c.isPresent()){
                Componente com = c.get();
                com.setModelo(null);
                componenteService.save(com);
            }
        }
    }
}
