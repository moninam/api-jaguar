package com.uady.apijaguar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.uady.apijaguar.dto.DeleteDto;
import com.uady.apijaguar.dto.MultimediaRequestDto;
import com.uady.apijaguar.dto.MultimediaUpdateDto;
import com.uady.apijaguar.exception.InvalidOperationException;
import com.uady.apijaguar.exception.NotFoundException;
import com.uady.apijaguar.model.Multimedia;
import com.uady.apijaguar.model.MultimediaComponente;
import com.uady.apijaguar.model.Museo;
import com.uady.apijaguar.repository.MultimediaRepository;
import com.uady.apijaguar.util.Constantes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class MultimediaService {
    @Autowired
    MultimediaRepository multimediaRepository;

    @Autowired
    MuseoService museoService;

    @Autowired
    ComponenteService componenteService;

    @Autowired
    JoinComponentService componentJService;

    private Logger logger = LogManager.getLogger(this.getClass());

    public Multimedia findById(Integer id){
        Optional<Multimedia> mult = multimediaRepository.findById(id);

        if (!mult.isPresent()) {
            throw new NotFoundException(Constantes.MULT_NOT_FOUND);
        }
        return mult.get();
    }
    public Set<Multimedia> getMultimediaByIdMuseo(Integer idMuseo){
        Optional<Museo> m = museoService.getById(idMuseo);

        if (!m.isPresent()){
            throw new NotFoundException(Constantes.MUSEO_NOT_FOUND);
        }
        Museo museo = m.get();
        Set<Multimedia> multimedia = museo.getMultimedia();

        return multimedia;
    }

    @Transactional(rollbackFor = Exception.class)
    public Multimedia createMultimedia(MultimediaRequestDto request){
        Optional<Museo> m = museoService.getById(request.getIdMuseo());

        if (!m.isPresent()){
            throw new NotFoundException(Constantes.MUSEO_NOT_FOUND);
        }
        Museo museo = m.get();

        Multimedia multimedia = new Multimedia(
                                request.getUrlUbicacion(),
                                request.getTipo(),
                                request.getNombre()
                                );
        Multimedia multNuevo = multimediaRepository.save(multimedia);
        museo.addMultimedia(multNuevo);
        museoService.save(museo);
        return multNuevo;
    }
    @Transactional(rollbackFor = Exception.class)
    public Multimedia updateMultimedia(MultimediaUpdateDto request,Integer idMultimedia){
        Multimedia mult = findById(idMultimedia);

        mult.setUrlUbicacion(request.getUrlUbicacion());
        mult.setMultimediaType(request.getTipo());
        mult.setNombre(request.getNombre());
        
        Multimedia multNuevo = multimediaRepository.save(mult);

        return multNuevo; 
    }
    @Transactional(rollbackFor = Exception.class)
    public DeleteDto deleteMultimedia(Integer id, Integer idMuseo){
        Optional<Museo> mOpt = museoService.getById(idMuseo);
        Optional<Multimedia> multOpt = multimediaRepository.findById(id);

        if(!mOpt.isPresent()){
            throw new NotFoundException(Constantes.MUSEO_NOT_FOUND);
        }
        if (!multOpt.isPresent()){
            throw new NotFoundException(Constantes.MULT_NOT_FOUND);
        }

        Museo m = mOpt.get();
       
        if(m.containsMult(multOpt.get())){
            m.removeMultimedia(multOpt.get());
            museoService.save(m);
        }
        List<MultimediaComponente> componentes = componentJService.getComponentesByMultimedia(id);
        if (!componentes.isEmpty()){
            throw new InvalidOperationException(Constantes.MULT_CANT_DELETE);
        }
        multimediaRepository.delete(multOpt.get());

        DeleteDto delete = new DeleteDto(200,Constantes.MULT_DELETE_SUCCESS);
        
        return delete;
    }
}
