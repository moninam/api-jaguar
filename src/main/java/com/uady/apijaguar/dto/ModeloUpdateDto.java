package com.uady.apijaguar.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.uady.apijaguar.util.Constantes;

public class ModeloUpdateDto {
    @NotEmpty(message=Constantes.URL_MODELO_EMPTY)
    private String urlModelo;

    @NotEmpty(message=Constantes.NOMBRE_EMPTY)
    private String nombre;

    @NotEmpty(message=Constantes.NOMBRE_ANIMACION_EMPTY)
    private String nombreAnimacion;

    @NotNull(message = Constantes.HAS_ROTATION_EMPTY)
    private Boolean hasRotation;

    @NotNull(message = Constantes.HAS_MOVEMENT_EMPTY)
    private Boolean hasMovement;

    @NotNull(message = Constantes.HAS_RESIZE_EMPTY)
    private Boolean hasResize;

    @NotEmpty(message=Constantes.TEXTURA_PATH_EMPTY)
    private String texturaPath;

    //GETTERS
    public String getUrlModelo(){
        return this.urlModelo;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getNombreAnimacion(){
        return this.nombreAnimacion;
    }
    public Boolean getHasRotation(){
        return this.hasRotation;
    }
    public Boolean getHasMovement(){
        return this.hasMovement;
    }
    public Boolean getHasResize(){
        return this.hasResize;
    }
    public String getTexturaPath(){
        return this.texturaPath;
    }

    //Setters
    public void setUrlModelo(String urlModelo){
        this.urlModelo = urlModelo;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setNombreAnimacion(String nombreAnimacion){
        this.nombreAnimacion = nombreAnimacion;
    }
    public void setHasRotation(Boolean hasRotation){
        this.hasRotation = hasRotation;
    }
    public void setHasMovement(Boolean hasMovement){
        this.hasMovement = hasMovement;
    }
    public void setHasResize(Boolean hasResize){
        this.hasResize = hasResize;
    }
    public void setTexturaPath(String texturaPath){
        this.texturaPath = texturaPath;
    }
}
