package com.uady.apijaguar.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.uady.apijaguar.enums.MultimediaType;
import com.uady.apijaguar.util.Constantes;

public class MultimediaUpdateDto {
    @NotEmpty(message=Constantes.URL_UBICACION_EMPTY)
    private String urlUbicacion;

    @NotNull(message = Constantes.TIPO_MULT_EMPTY)
    @Enumerated(EnumType.STRING)
    private MultimediaType tipo;

    @NotEmpty(message=Constantes.NOMBRE_MULT_EMPTY)
    private String nombre;
    

    //Getters
    public String getUrlUbicacion(){
        return this.urlUbicacion;
    }
    public MultimediaType getTipo(){
        return this.tipo;
    }
    public String getNombre(){
        return this.nombre;
    }

    //Setters
    public void setUrlUbicacion(String urlUbicacion){
        this.urlUbicacion = urlUbicacion;
    }
    public void setTipo(MultimediaType tipo){
        this.tipo = tipo;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
