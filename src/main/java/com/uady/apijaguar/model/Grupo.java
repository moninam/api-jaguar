package com.uady.apijaguar.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="grupo")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_grupo")
    private Integer idGrupo;

    @ManyToOne
    @JoinColumn(name = "id_museo")
    @JsonBackReference
    private Museo museo;
    
    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="url_imagen")
    private String urlImagen;

    @Column(name="created_at")
    private Date createdDate;

    @Column(name="updated_at")
    private Date updatedDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="grupo_componente",joinColumns = @JoinColumn(name="id_grupo"),
    inverseJoinColumns = @JoinColumn(name="id_componente"))
    @JsonIgnore
    private Set<Componente> componentes = new HashSet<>();

    public Grupo(){}

    public Grupo(Museo museo, String nombre, String descripcion, String urlImagen,
                Date createdDate, Date updatedDate)
    {
        this.museo = museo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    //GETTERS
    public Integer getIdGrupo(){
        return this.idGrupo;
    }
    public Museo getMuseo(){
        return this.museo;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public String getUrlImagen(){
        return this.urlImagen;
    }
    public Date getCreatedDate(){
        return this.createdDate;
    }
    public Date getUpdatedDate(){
        return this.updatedDate;
    }
    public Set<Componente> getComponentes(){
        return this.componentes;
    }

    //SETTERS
    public void setMuseo(Museo museo){
        this.museo = museo;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void setUrlImagen(String urlImagen){
        this.urlImagen = urlImagen;

    }
    public void setCreatedDate(Date createdDate){
        this.createdDate = createdDate;
    }
    public void setUpdatedDate(Date updatedDate){
        this.updatedDate = updatedDate;
    }
    public void setComponentes(Set<Componente> componentes){
        this.componentes = componentes;
    }
}
