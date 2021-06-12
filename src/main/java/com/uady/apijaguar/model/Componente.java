package com.uady.apijaguar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.uady.apijaguar.enums.ComponentType;

@Entity
@Table(name="componente")
public class Componente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_componente")
    private Integer idComponente;

    @Column(name="nombre")
    private String nombre;

    @Column(name="url_imagen")
    private String urlImagen;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="has_target")
    private Boolean hasTarget;

    @Column(name="component_type")
    @Enumerated(EnumType.STRING)
    private ComponentType componentType;

    @Column(name="has_description")
    private Boolean hasDescription;

    public Componente(String nombre, String urlImagen, String descripcion,
        Boolean hasTarget, ComponentType componentType, Boolean hasDescription)
    {
        this.nombre = nombre;
        this.urlImagen = urlImagen;
        this.descripcion = descripcion;
        this.hasTarget = hasTarget;
        this.componentType = componentType;
        this.hasDescription = hasDescription;
    }

    public Componente(){}

    //Getters
    public String getNombre(){
        return this.nombre;
    }

    public String getUrlImagen(){
        return this.urlImagen;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public ComponentType getComponentType(){
        return this.componentType;
    }

    public Boolean hasDescripcion(){
        return this.hasDescription;
    }

    public Boolean hasTarget(){
        return this.hasTarget;
    }

    //Setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setUrlImagen(String urlImagen){
        this.urlImagen = urlImagen;
    }

    public void setDescription(String descripcion){
        this.descripcion = descripcion;
    }
    
    public void isTarget(Boolean isTarget){
        this.hasTarget = isTarget;
    }

    public void setComponentType(ComponentType componentType){
        this.componentType = componentType;
    }

    public void isDescription(Boolean isDescription){
        this.hasDescription = isDescription;
    }

}
