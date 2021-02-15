package com.uady.apijaguar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "animacion")
public class Animacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idanimacion")
    private Integer idAnimacion;

    @Column(name="urlanimacion")
    private String urlAnimacion;

    public Animacion(String urlAnimacion){
        this.urlAnimacion = urlAnimacion;
    }

    public Animacion(){}

    public String getUrlAnimacion(){
        return this.urlAnimacion;
    }

    public void setUrlAnimacion(String urlAnimacion){
        this.urlAnimacion = urlAnimacion;
    }
}
