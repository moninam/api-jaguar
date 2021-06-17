package com.uady.apijaguar.dto;

import javax.validation.constraints.NotEmpty;

import com.uady.apijaguar.util.Constantes;

public class TargetUpdateDto {
    @NotEmpty(message=Constantes.URL_TARGET_EMPTY)
    private String urlTarget;
    
    @NotEmpty(message=Constantes.NOMBRE_EMPTY)
    private String nombre;


    //GETTERS
    public String getUrlTarget(){
        return this.urlTarget;
    }
    public String getNombre(){
        return this.nombre;
    }

    //SETTERS
    public void setUrlTarget(String urlTarget){
        this.urlTarget = urlTarget;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
