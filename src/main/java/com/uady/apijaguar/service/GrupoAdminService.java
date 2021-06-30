package com.uady.apijaguar.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import com.uady.apijaguar.dto.DeleteDto;
import com.uady.apijaguar.dto.GrupoRequestDto;
import com.uady.apijaguar.dto.GrupoUpdateDto;
import com.uady.apijaguar.exception.NotFoundException;
import com.uady.apijaguar.model.Componente;
import com.uady.apijaguar.model.Grupo;
import com.uady.apijaguar.model.Museo;
import com.uady.apijaguar.util.Constantes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GrupoAdminService {
    @Autowired
    GrupoService grupoService;

    @Autowired
    MuseoService museoService;

    public Grupo createGrupo(GrupoRequestDto request){
        Optional<Museo> museo = museoService.getById(request.getIdMuseo());

        if (!museo.isPresent()){
            throw new NotFoundException(Constantes.MUSEO_NOT_FOUND);
        }
        Date currentDate = new Date();
        Date lastUpdate = new Date();
        
        Grupo grupo = new Grupo(
                        museo.get(),
                        request.getNombre(),
                        request.getDescripcion(),
                        request.getUrlImagen(),
                        currentDate,
                        lastUpdate);

        grupoService.save(grupo);

        return grupo;
    }
    
    public Grupo updateGrupo(GrupoUpdateDto request, Integer idGrupo){
        Grupo grupo = grupoService.findById(idGrupo);

        grupo.setNombre(request.getNombre());
        grupo.setDescripcion(request.getDescripcion());
        grupo.setUrlImagen(request.getUrlImagen());

        grupoService.save(grupo);

        return grupo;
    }

    public DeleteDto deleteGrupo(Integer idGrupo){
        Grupo grupo = grupoService.findById(idGrupo);

        for(Componente componente: grupo.getComponentes()) {
            grupo.removeComponente(componente);
        }

        grupoService.deleteGrupo(grupo);
        DeleteDto delete = new DeleteDto(200,Constantes.GRUPO_DELETE);

        return delete;
    }
}
