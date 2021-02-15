package com.uady.apijaguar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marcador")
public class Marcador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmarcador")
    private Integer idMarcador;

    @Column(name="nombremarcador")
    private String nombreMarcador;

    @Column(name="urlmarcador")
    private String urlMarcador;

    public Marcador(String nombreMarcador, String urlMarcador){
        this.nombreMarcador = nombreMarcador;
        this.urlMarcador = urlMarcador;
    }

    public Marcador(){}

    public Integer getIdMarcador(){
        return this.idMarcador;
    }

    public String getNombreMarcador(){
        return this.nombreMarcador;
    }

    public String getUrlMarcador(){
        return this.urlMarcador;
    }

    public void setNombreMarcador(String nombreMarcador){
        this.nombreMarcador = nombreMarcador;
    }

    public void setUrlMarcador(String urlMarcador){
        this.urlMarcador = urlMarcador;
    }

}
