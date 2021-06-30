package com.uady.apijaguar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="modelo")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_modelo")
    private Integer idModelo;

    @Column(name="url_modelo")
    private String urlModelo;

    @Column(name="nombre")
    private String nombre;

    @Column(name="nombre_animacion")
    private String nombreAnimacion;

    @Column(name="has_rotation")
    private Boolean hasRotation;

    @Column(name="has_movement")
    private Boolean hasMovement;

    @Column(name="has_resize")
    private Boolean hasResize;

    @Column(name="textura_path")
    private String texturaPath;

    public Modelo(){}

    public Modelo(String urlModelo, String nombre, String nombreAnimacion,
                Boolean hasRotation, Boolean hasMovement, Boolean hasResize,
                String texturaPath)
    {
        this.urlModelo = urlModelo;
        this.nombre = nombre;
        this.nombreAnimacion = nombreAnimacion;
        this.hasRotation = hasRotation;
        this.hasMovement = hasMovement;
        this.hasResize = hasResize;
        this.texturaPath = texturaPath;
    }

    //GETTERS
    public Integer getIdModelo(){
        return this.idModelo;
    }
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

    //SETTERS
    public void setUrlModelo(String urlModelo){
        this.urlModelo = urlModelo;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setNombreAnimacion(String nombreAnimacion){
        this.nombreAnimacion = nombreAnimacion;
    }
    public void isRotation(Boolean hasRotation){
        this.hasRotation = hasRotation;
    }
    public void isMovement(Boolean hasMovement){
        this.hasMovement = hasMovement;
    }
    public void isResize(Boolean hasResize){
        this.hasResize = hasResize;
    }
    public void setTexturaPath(String texturaPath){
        this.texturaPath = texturaPath;
    }
}
