package com.uady.apijaguar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="target")
public class Target {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_target")
    private Integer idTarget;

    @Column(name="url_target")
    private String urlTarget;

    @Column(name="nombre")
    private String nombre;

    public Target(){}

    public Target(String urlTarget, String nombre){
        this.urlTarget = urlTarget;
        this.nombre = nombre;
    }

    //GETTERS
    public Integer getIdTarget(){
        return this.idTarget;
    }
    public String getUrlTarget(){
        return this.urlTarget;
    }
    public String getNombre(){
        return this.nombre;
    }

    //SETTERS
    public void setUrlTarget(String urlTarget){
        this.urlTarget = urlTarget;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
