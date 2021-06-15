package com.uady.apijaguar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.uady.apijaguar.enums.MultimediaType;

@Entity
@Table(name="multimedia")
public class Multimedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_multimedia")
    private Integer idMultimedia;

    @Column(name="url_ubicacion")
    private String urlUbicacion;

    @Column(name="multimedia_type")
    @Enumerated(EnumType.STRING)
    private MultimediaType multimediaType;

    @Column(name="nombre")
    private String nombre;

    public Multimedia(){}

    public Multimedia(String urlUbicacion, MultimediaType multimediaType, String nombre){
        this.urlUbicacion = urlUbicacion;
        this.multimediaType = multimediaType;
        this.nombre = nombre;
    }

    //GETTERS
    public Integer getIdMultimedia(){
        return this.idMultimedia;
    }
    public String getUrlUbicacion(){
        return this.urlUbicacion;
    }
    public MultimediaType getMultimediaType(){
        return this.multimediaType;
    }
    public String getNombre(){
        return this.nombre;
    }

    //SETTERS
    public void setUrlUbicacion(String urlUbicacion){
        this.urlUbicacion = urlUbicacion;
    }
    public void setMultimediaType(MultimediaType multimediaType){
        this.multimediaType = multimediaType;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
