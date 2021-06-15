package com.uady.apijaguar.dto;

import javax.validation.constraints.NotEmpty;

import com.uady.apijaguar.util.Constantes;

public class GrupoUpdateDto {

    @NotEmpty(message=Constantes.NOMBRE_EMPTY)
    private String nombre;

    @NotEmpty(message=Constantes.EMPTY_DESCRIPTION)
    private String descripcion;

    @NotEmpty(message=Constantes.EMPTY_URL_IMAGEN)
    private String urlImagen;

    //GETTERS
    public String getNombre(){
        return this.nombre;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public String getUrlImagen(){
        return this.urlImagen;
    }
    
    //SETTERS
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void setUrlImagen(String urlImagen){
        this.urlImagen = urlImagen;
    }
}
