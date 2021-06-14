package com.uady.apijaguar.dto;

import javax.validation.constraints.NotNull;

import com.uady.apijaguar.util.Constantes;

public class UbicacionDto {

    @NotNull(message=Constantes.EMPTY_LAT)
    private Double latitud;

    @NotNull(message=Constantes.EMPTY_LONG)
    private Double longitud;

    //GETTERS
    public Double getLatitud(){
        return this.latitud;
    }

    public Double getLongitud(){
        return this.longitud;
    }

    //SETTERS
    public void setLatitud(Double latitud){
        this.latitud = latitud;
    }

    public void setLongitud(Double longitud){
        this.longitud = longitud;
    }
    
}
