package com.uady.apijaguar.service;

import java.util.List;
import java.util.Optional;

import com.uady.apijaguar.model.GrupoComponente;
import com.uady.apijaguar.model.ModeloComponente;
import com.uady.apijaguar.model.MultimediaComponente;
import com.uady.apijaguar.model.TargetComponente;
import com.uady.apijaguar.repository.GrupoComponenteRepository;
import com.uady.apijaguar.repository.ModeloComponenteRepository;
import com.uady.apijaguar.repository.MultimediaComponenteRepository;
import com.uady.apijaguar.repository.TargetComponenteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinComponentService {
    @Autowired
    GrupoComponenteRepository grupoComponenteRepository;

    @Autowired
    ModeloComponenteRepository modeloComponenteRepository;

    @Autowired
    MultimediaComponenteRepository multimediaComponenteRepository;

    @Autowired
    TargetComponenteRepository targetComponenteRepository;

    public Optional<GrupoComponente> getGrupoByIdComponente(Integer idComponente){
        return grupoComponenteRepository.findByIdComponente(idComponente);
    }
    public Optional<ModeloComponente> getModeloByIdComponente(Integer idComponente){
        return modeloComponenteRepository.findByIdComponente(idComponente);
    }
    public Optional<MultimediaComponente> getMultimediaByIdComponente(Integer idComponente){
        return multimediaComponenteRepository.findByIdComponente(idComponente);
    }
    public Optional<TargetComponente> getTargetByIdComponente(Integer idComponente){
        return targetComponenteRepository.findByIdComponente(idComponente);
    }
    public void saveGrupo(GrupoComponente grupo){
        this.grupoComponenteRepository.save(grupo);
    }
    public void saveMultimedia(MultimediaComponente multimedia){
        this.multimediaComponenteRepository.save(multimedia);
    }
    public void saveModelo(ModeloComponente modelo){
        this.modeloComponenteRepository.save(modelo);
    }
    public void saveTarget(TargetComponente target){
        this.targetComponenteRepository.save(target);
    }
    public void deleteGrupo(GrupoComponente grupo){
        this.grupoComponenteRepository.delete(grupo);
    }
    public void deleteMultimedia(MultimediaComponente multimedia){
        this.multimediaComponenteRepository.delete(multimedia);
    }
    public void deleteModelo(ModeloComponente modelo){
        this.modeloComponenteRepository.delete(modelo);
    }
    public void deleteTarget(TargetComponente target){
        this.targetComponenteRepository.delete(target);
    }
    public List<ModeloComponente> getComponentesByModelo(Integer idModelo){
        return modeloComponenteRepository.findByIdModelo(idModelo);
    }
    public List<MultimediaComponente> getComponentesByMultimedia(Integer idMultimedia){
        return multimediaComponenteRepository.findByIdMultimedia(idMultimedia);
    }
    public List<TargetComponente> getComponentesByTarget(Integer idTarget){
        return targetComponenteRepository.findByIdTarget(idTarget);
    }

}
