package com.uady.apijaguar.service;

import com.uady.apijaguar.exception.NotFoundException;
import com.uady.apijaguar.model.Cuenta;
import com.uady.apijaguar.model.Museo;
import com.uady.apijaguar.model.request.MuseoRequest;
import com.uady.apijaguar.repository.MuseoRepository;
import com.uady.apijaguar.util.Constantes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MuseoService {
    @Autowired
    MuseoRepository museoRepository;

    @Autowired
    CuentaService cuentaService;

    private Logger logger = LogManager.getLogger(this.getClass());

    public Museo crearMuseo(MuseoRequest request){

        //Creamos el museo
        Museo museo = new Museo();
        //Buscamos la cuenta
        Cuenta cuenta = cuentaService.findCuenta(request.getIdCuenta());

        if(cuenta == null){
            throw new NotFoundException(Constantes.ENTITY_NOT_FOUND);
        }

        museo.setUbicacion(request.getUbicacion());
        museo.setTelefono(request.getTelefono());
        museo.setDireccion(request.getDireccion());
        museo.setNombre(request.getName());
        museo.setCuenta(cuenta);

        museo = museoRepository.save(museo);

        return museo;
    }
}
