package com.uady.apijaguar.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="componente_target")
public class TargetComponente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_componente_target")
    private Integer idComponenteTarget;
    
    @Column(name="id_componente")
    private Integer idComponente;

    @Column(name="id_target")
    private Integer idTarget;

    public TargetComponente(Integer idComponente, Integer idTarget){
        this.idComponente = idComponente;
        this.idTarget = idTarget;
    }

    public TargetComponente(){}

    //Getters
    public Integer getIdComponenteTarget(){
        return this.idComponenteTarget;
    }
    public Integer getIdComponente(){
        return this.idComponente;
    }
    public Integer getIdTarget(){
        return this.idTarget;
    }

    //Setters
    public void setIdComponente(Integer idComponente){
        this.idComponente = idComponente;
    }
    public void setIdGrupo(Integer idTarget){
        this.idTarget = idTarget;
    }
}
