package com.uady.apijaguar.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="componente_modelo")
public class ModeloComponente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_componente_modelo")
    private Integer idComponenteModelo;

    @Column(name="id_componente")
    private Integer idComponente;

    @Column(name="id_modelo")
    private Integer idModelo;

    public ModeloComponente(Integer idComponente, Integer idModelo){
        this.idComponente = idComponente;
        this.idModelo = idModelo;
    }

    public ModeloComponente(){}

    //Getters
    public Integer getIdComponenteModelo(){
        return this.idComponenteModelo;
    }
    public Integer getIdComponente(){
        return this.idComponente;
    }
    public Integer getIdModelo(){
        return this.idModelo;
    }

    //Setters
    public void setIdComponente(Integer idComponente){
        this.idComponente = idComponente;
    }
    public void setIdModelo(Integer idModelo){
        this.idModelo = idModelo;
    }
}
