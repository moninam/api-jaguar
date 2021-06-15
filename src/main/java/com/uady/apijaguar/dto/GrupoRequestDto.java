package com.uady.apijaguar.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.uady.apijaguar.util.Constantes;

public class GrupoRequestDto {

    @NotEmpty(message=Constantes.NOMBRE_EMPTY)
    private String nombre;

    @NotEmpty(message=Constantes.EMPTY_DESCRIPTION)
    private String descripcion;

    @NotEmpty(message=Constantes.EMPTY_URL_IMAGEN)
    private String urlImagen;

    @NotNull(message = Constantes.MUSEO_EMPTY)
    @Min(value=1,message= Constantes.MUSEO_NOT_VALID)
    private Integer idMuseo;

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
    public Integer getIdMuseo(){
        return this.idMuseo;
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
