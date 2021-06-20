package com.uady.apijaguar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name="componente_modelo",joinColumns = @JoinColumn(name="id_componente"),
    inverseJoinColumns = @JoinColumn(name="id_modelo"))
    private Modelo modelo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name="componente_multimedia",joinColumns = @JoinColumn(name="id_componente"),
    inverseJoinColumns = @JoinColumn(name="id_multimedia"))
    private Multimedia multimedia;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name="componente_target",joinColumns = @JoinColumn(name="id_componente"),
    inverseJoinColumns = @JoinColumn(name="id_target"))
    private Target target;

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
    public Integer getIdComponente(){
        return this.idComponente;
    }
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

    public Boolean getHasDescripcion(){
        return this.hasDescription;
    }

    public Boolean getHasTarget(){
        return this.hasTarget;
    }

    public Modelo getModelo(){
        return this.modelo;
    }

    public Multimedia getMultimedia(){
        return this.multimedia;
    }
    
    public Target getTarget(){
        return this.target;
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

    public void setModelo(Modelo modelo){
        this.modelo = modelo;
    }

    public void setMultimedia(Multimedia multimedia){
        this.multimedia = multimedia;
    }

    public void setTarget(Target target){
        this.target = target;
    }
}
