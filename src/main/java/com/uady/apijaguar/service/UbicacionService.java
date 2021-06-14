package com.uady.apijaguar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.uady.apijaguar.collection.MuseoUbicacion;
import com.uady.apijaguar.dto.MuseoResponseDto;
import com.uady.apijaguar.dto.UbicacionDto;
import com.uady.apijaguar.exception.NotFoundException;
import com.uady.apijaguar.model.Museo;
import com.uady.apijaguar.util.Constantes;
import com.uady.apijaguar.util.LocationOperation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class UbicacionService {
    private Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    MuseoService museoService;

    public MuseoResponseDto getNearestLocation(UbicacionDto ubicacion){
        List<Museo> museos = museoService.getAllMuseos();

        if (museos.isEmpty()) {
            throw new NotFoundException(Constantes.MUSEO_NOT_FOUND);
        }
        ArrayList<MuseoUbicacion> locations = getValidUbications(museos, ubicacion);

        if(locations.isEmpty()){
            throw new NotFoundException(Constantes.MUSEO_NOT_FOUND);
        }
        Museo museo = locations.get(0).getMuseo();

        MuseoResponseDto response = new MuseoResponseDto(museo.getId(), museo.getNombre(), museo.getTelefono(), museo.getDireccion());
        logger.info("Museo {}",museo.getNombre());
        
        return response;
    }

    private ArrayList<MuseoUbicacion> getValidUbications(List<Museo> museos, UbicacionDto ubicacion){
        ArrayList<MuseoUbicacion> ubicaciones = new ArrayList<>();

        Double latitudU = ubicacion.getLatitud();
        Double longitudU = ubicacion.getLongitud();

        for(Museo item:museos){
            Double latitudM = item.getLatitud();
            Double longitudM = item.getLongitud();
            double distancia = LocationOperation.getInstance().distance(latitudU, longitudU, latitudM, longitudM);
            
            if(distancia < 0.8){
                MuseoUbicacion ubiActual = new MuseoUbicacion();
                ubiActual.setDistance(distancia);
                ubiActual.setMuseo(item);

                ubicaciones.add(ubiActual);
            }
        }
        Collections.sort(ubicaciones);
        return ubicaciones;
    }

}
