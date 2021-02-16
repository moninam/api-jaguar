package com.uady.apijaguar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "modelo")
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmodelo")
    private Integer idModelo;

    @Column(name="urlmodelo")
    private String urlModelo;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="icono")
    private String icono;

    @ManyToOne
    @JoinColumn(name = "idmarcador", referencedColumnName = "idmarcador")
    private Marcador marcador;

    @ManyToOne
    @JoinColumn(name = "idanimacion", referencedColumnName = "idanimacion")
    private Animacion animacion;

    @ManyToOne
    @JoinColumn(name = "idcontenido", referencedColumnName = "idcontenido")
    private ContenidoExtra contenido;

    public Modelo(String urlModelo, String descripcion, Marcador marcador, Animacion animacion, ContenidoExtra contenido){
        this.urlModelo = urlModelo;
        this.descripcion = descripcion;
        this.marcador = marcador;
        this.animacion = animacion;
        this.contenido = contenido;
    }

    public Modelo(){}

    public Integer getIdModelo(){
        return this.idModelo;
    }

    public String getUrlModelo(){
        return this.urlModelo;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public Marcador getMarcador(){
        return this.marcador;
    }

    public Animacion getAnimacion(){
        return this.animacion;
    }

    public String getIcono(){
        return this.icono;
    }

    public ContenidoExtra getContenido(){
        return this.contenido;
    }

    public void setUrlModelo(String urlModelo){
        this.urlModelo = urlModelo;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setMarcador(Marcador marcador){
        this.marcador = marcador;
    }

    public void setAnimacion(Animacion animacion){
        this.animacion = animacion;
    }

    public void setContenido(ContenidoExtra contenido){
        this.contenido = contenido;
    }

    public void setIcono(String icono){
        this.icono = icono;
    }
    
}
