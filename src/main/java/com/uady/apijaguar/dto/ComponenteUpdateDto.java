package com.uady.apijaguar.dto;

import com.uady.apijaguar.enums.ComponentType;

public class ComponenteUpdateDto {
    private String nombre;
    private Integer idGrupo;
    private String descripcion;
    private Integer idMarcador;
    private ComponentType tipoComponente;
    private Integer idElemento;
    private String urlImagen;

    //GETTER
    public String getNombre(){
        return this.nombre;
    }
    public Integer getIdGrupo(){
        return this.idGrupo;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public Integer getIdMarcador(){
        return this.idMarcador;
    }
    public ComponentType getTipoComponente(){
        return this.tipoComponente;
    }
    public Integer getIdElemento(){
        return this.idElemento;
    }
    public String getUrlImagen(){
        return this.urlImagen;
    }
    
    //SETTER
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setIdGrupo(Integer idGrupo){
        this.idGrupo = idGrupo;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void setMarcador(Integer idMarcador){
        this.idMarcador = idMarcador;
    }
    public void setTipoComponente(ComponentType tipoComponente){
        this.tipoComponente = tipoComponente;
    }
    public void setIdElemento(Integer idElemento){
        this.idElemento = idElemento;
    }
    public void setUrlImagen(String urlImagen){
        this.urlImagen = urlImagen;
    }

}
