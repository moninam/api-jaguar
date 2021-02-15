package com.uady.apijaguar.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idgrupo")
    private Integer idGrupo;

    @Column(name = "nombregrupo")
    private String nombreGrupo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "registerdate")
    private Date registerDate;

    @Column(name = "lastupdate")
    private Date lastUpdate;

    @Column(name="imagen")
    private String imagen;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idmuseo", referencedColumnName = "idmuseo")
    private Museo museo;

    public Grupo(String nombreGrupo, String descripcion, Date registerDate, Date lastUpdate,String imagen,  Museo museo){
        this.nombreGrupo = nombreGrupo;
        this.descripcion = descripcion;
        this.registerDate = registerDate;
        this.lastUpdate = lastUpdate;
        this.museo = museo;
        this.imagen = imagen;
    }

    public Grupo(){}

    public Integer getIdGrupo(){
        return this.idGrupo;
    }

    public String getNombreGrupo(){
        return this.nombreGrupo;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public Date getRegisterDate(){
        return this.registerDate;
    }

    public Date getLastUpdate(){
        return this.lastUpdate;
    }

    public String getImagen(){
        return this.imagen;
    }

    public Museo getMuseo(){
        return this.museo;
    }

    public void setNombreGrupo(String nombreGrupo){
        this.nombreGrupo = nombreGrupo;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setRegisterDate(Date registerDate){
        this.registerDate = registerDate;
    }

    public void setLastUpdate(Date lastUpdate){
        this.lastUpdate = lastUpdate;
    }
    
    public void setImagen(String imagen){
        this.imagen = imagen;
    }
    
    public void setMuseo(Museo museo){
        this.museo = museo;
    }
}
