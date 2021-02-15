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

@Entity
@Table(name="grupo_modelo")
public class GrupoModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idgrupomodelo")
    private Integer idGrupoModelo;

    @Column(name="registerdate")
    private Date registerDate;

    @Column(name="isactive")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "idgrupo", referencedColumnName = "idgrupo")
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "idmodelo", referencedColumnName = "idmodelo")
    private Modelo modelo;

    public GrupoModelo(Date registerDate, Boolean isActive, Grupo grupo, Modelo modelo){
        this.registerDate = registerDate;
        this.isActive = isActive;
        this.grupo = grupo;
        this.modelo = modelo;
    }

    public GrupoModelo(){}

    public Integer getIdGrupoModelo(){
        return this.idGrupoModelo;
    }

    public Date getRegisterDate(){
        return this.registerDate;
    }

    public Boolean isActive(){
        return this.isActive;
    }

    public Grupo getGrupo(){
        return this.grupo;
    }

    public Modelo getModelo(){
        return this.modelo;
    }

    public void setRegisterDate(Date registerDate){
        this.registerDate = registerDate;
    }

    public void setIsActive(Boolean isActive){
        this.isActive = isActive;
    }

    public void setGrupo(Grupo grupo){
        this.grupo = grupo;
    }

    public void setModelo(Modelo modelo){
        this.modelo = modelo;
    }

    
}
