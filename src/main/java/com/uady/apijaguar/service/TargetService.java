package com.uady.apijaguar.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.uady.apijaguar.dto.DeleteDto;
import com.uady.apijaguar.dto.TargetRequestDto;
import com.uady.apijaguar.dto.TargetUpdateDto;
import com.uady.apijaguar.exception.NotFoundException;
import com.uady.apijaguar.model.Componente;
import com.uady.apijaguar.model.Museo;
import com.uady.apijaguar.model.Target;
import com.uady.apijaguar.model.TargetComponente;
import com.uady.apijaguar.repository.TargetRepository;
import com.uady.apijaguar.util.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Service
public class TargetService {
    @Autowired
    TargetRepository targetRepository;

    @Autowired
    MuseoService museoService;

    @Autowired
    ComponenteService componenteService;

    @Autowired
    JoinComponentService componentJService;

    private Logger logger = LogManager.getLogger(this.getClass());

    public Optional<Target> findById(Integer id){
        return targetRepository.findById(id);
    }

    public Set<Target> getTargetByIdMuseo(Integer idMuseo){
        Optional<Museo> m = museoService.getById(idMuseo);

        if (!m.isPresent()){
            throw new NotFoundException(Constantes.MUSEO_NOT_FOUND);
        }
        Museo museo = m.get();
        Set<Target> targets = museo.getTargets();

        return targets;
    }

    @Transactional(rollbackFor = Exception.class)
    public Target createTarget(TargetRequestDto request){
        Optional<Museo> m = museoService.getById(request.getIdMuseo());

        if (!m.isPresent()){
            throw new NotFoundException(Constantes.MUSEO_NOT_FOUND);
        }
        Museo museo = m.get();

        Target target = new Target(request.getUrlTarget(),request.getNombre());
        Target targetNuevo = targetRepository.save(target);

        museo.addTarget(targetNuevo);
        museoService.save(museo);
        return targetNuevo;
    }

    @Transactional(rollbackFor = Exception.class)
    public Target updateTarget(TargetUpdateDto request,Integer idTarget){
        Optional<Target> target = findById(idTarget);

        if(!target.isPresent()){
            throw new NotFoundException(Constantes.TARGET_NOT_FOUND);
        }
        Target tReal = target.get();

        tReal.setNombre(request.getNombre());
        tReal.setUrlTarget(request.getUrlTarget());
        
        Target targetNuevo = targetRepository.save(tReal);

        return targetNuevo; 
    }
    @Transactional(rollbackFor = Exception.class)
    public DeleteDto deleteTarget(Integer id, Integer idMuseo){
        Optional<Museo> mOpt = museoService.getById(idMuseo);
        Optional<Target> targetOpt = findById(id);

        if(!mOpt.isPresent()){
            throw new NotFoundException(Constantes.MUSEO_NOT_FOUND);
        }
        if (!targetOpt.isPresent()){
            throw new NotFoundException(Constantes.TARGET_DO_NOT_EXIST);
        }

        Museo m = mOpt.get();
       
        if(m.containsTarget(targetOpt.get())){
            m.removeTarget(targetOpt.get());
            museoService.save(m);
        }
        List<TargetComponente> componentes = componentJService.getComponentesByTarget(id);
        manageComponents(componentes);
        targetRepository.delete(targetOpt.get());

        DeleteDto delete = new DeleteDto(200,Constantes.TARGET_DELETE_SUCCESS);
        
        return delete;
    }
    private void manageComponents(List<TargetComponente> componentes){
        for(TargetComponente item: componentes){
            Optional<Componente> c = componenteService.getById(item.getIdComponente());
            if(c.isPresent()){
                Componente com = c.get();
                com.setTarget(null);
                componenteService.save(com);
            }
        }
    }
}
