package com.uady.apijaguar.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name="componente_multimedia")
public class MultimediaComponente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_componente_multimedia")
    private Integer idComponenteMultimedia;

    @Column(name="id_componente")
    private Integer idComponente;

    @Column(name="id_multimedia")
    private Integer idMultimedia;

    public MultimediaComponente(Integer idComponente, Integer idMultimedia){
        this.idComponente = idComponente;
        this.idMultimedia= idMultimedia;
    }

    public MultimediaComponente(){}

    //Getters
    public Integer getIdComponenteMultimedia(){
        return this.idComponenteMultimedia;
    }
    public Integer getIdComponente(){
        return this.idComponente;
    }
    public Integer getIdMultimedia(){
        return this.idMultimedia;
    }

    //Setters
    public void setIdComponente(Integer idComponente){
        this.idComponente = idComponente;
    }
    public void setIdMultimedia(Integer idMultimedia){
        this.idMultimedia = idMultimedia;
    }
}
