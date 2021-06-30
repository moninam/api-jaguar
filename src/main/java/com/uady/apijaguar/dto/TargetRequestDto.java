package com.uady.apijaguar.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.uady.apijaguar.util.Constantes;

public class TargetRequestDto {
    @NotEmpty(message=Constantes.URL_TARGET_EMPTY)
    private String urlTarget;
    
    @NotEmpty(message=Constantes.NOMBRE_EMPTY)
    private String nombre;

    @NotNull(message = Constantes.MUSEO_EMPTY)
    @Min(value=1,message= Constantes.MUSEO_NOT_VALID)
    private Integer idMuseo;

    //GETTERS
    public String getUrlTarget(){
        return this.urlTarget;
    }
    public String getNombre(){
        return this.nombre;
    }
    public Integer getIdMuseo(){
        return this.idMuseo;
    }

    //SETTERS
    public void setUrlTarget(String urlTarget){
        this.urlTarget = urlTarget;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

}
