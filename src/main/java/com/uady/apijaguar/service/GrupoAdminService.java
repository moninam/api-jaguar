package com.uady.apijaguar.service;
import java.util.Date;

import com.uady.apijaguar.dto.GrupoRequestDto;
import com.uady.apijaguar.exception.NotFoundException;
import com.uady.apijaguar.model.Grupo;
import com.uady.apijaguar.model.Museo;
import com.uady.apijaguar.util.Constantes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoAdminService {
    @Autowired
    GrupoService grupoService;

    @Autowired
    MuseoService museoService;

    public Grupo createGrupo(GrupoRequestDto request){
        Museo museo = museoService.getById(request.getIdMuseo());

        if (museo == null){
            throw new NotFoundException(Constantes.MUSEO_NOT_FOUND);
        }
        Date currentDate = new Date();
        Date lastUpdate = new Date();
        
        Grupo grupo = new Grupo(
                        museo,
                        request.getNombre(),
                        request.getDescripcion(),
                        request.getUrlImagen(),
                        currentDate,
                        lastUpdate);

        grupoService.save(grupo);

        return grupo;
    }
}
