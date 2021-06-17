package com.uady.apijaguar.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="grupo_componente")
public class GrupoComponente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_grupo_componente")
    private Integer idGrupoComponente;

    @Column(name="id_componente")
    private Integer idComponente;

    @Column(name="id_grupo")
    private Integer idGrupo;

    public GrupoComponente(Integer idComponente, Integer idGrupo){
        this.idComponente = idComponente;
        this.idGrupo = idGrupo;
    }

    public GrupoComponente(){}

    //Getters
    public Integer getIdGrupoComponente(){
        return this.idGrupoComponente;
    }
    public Integer getIdComponente(){
        return this.idComponente;
    }
    public Integer getIdGrupo(){
        return this.idGrupo;
    }

    //Setters
    public void setIdComponente(Integer idComponente){
        this.idComponente = idComponente;
    }
    public void setIdGrupo(Integer idGrupo){
        this.idGrupo = idGrupo;
    }
}
