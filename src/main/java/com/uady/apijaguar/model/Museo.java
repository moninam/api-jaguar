package com.uady.apijaguar.model;

import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.metamodel.model.domain.internal.SetAttributeImpl;

@Entity
@Table(name = "museo")
public class Museo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idMuseo")
    private Integer idMuseo;

    @Column(name="direccion")
    private String direccion;

    @Column(name="longitud")
    private Double longitud;

    @Column(name="latitud")
    private Double latitud;

    @Column(name = "nombre")
    private String nombre;

    @Column(name="telefono")
    private String telefono;

    @OneToMany(mappedBy = "museo")
    @JsonIgnore
    List<Grupo> grupos;

    @OneToOne
    @JoinColumn(name = "idCuenta", referencedColumnName = "idCuenta")
    @JsonIgnore
    private Cuenta cuenta;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="modelo_museo",joinColumns = @JoinColumn(name="id_museo"),
    inverseJoinColumns = @JoinColumn(name="id_modelo"))
    @JsonIgnore
    private Set<Modelo> modelos;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="multimedia_museo",joinColumns = @JoinColumn(name="id_museo"),
    inverseJoinColumns = @JoinColumn(name="id_multimedia"))
    @JsonIgnore
    private Set<Multimedia> multimedia;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="target_museo",joinColumns = @JoinColumn(name="id_museo"),
    inverseJoinColumns = @JoinColumn(name="id_target"))
    @JsonIgnore
    private Set<Target> targets;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="componente_museo",joinColumns = @JoinColumn(name="id_museo"),
    inverseJoinColumns = @JoinColumn(name="id_componente"))
    @JsonIgnore
    private Set<Componente> componentes;

    public Museo(String nombre, String direccion,Double latitud, Double longitud, String telefono, Cuenta cuenta){
        this.nombre = nombre;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.telefono = telefono;
        this.cuenta = cuenta;
    }

    public Museo(){}

    //Getters

    public Integer getId(){
        return this.idMuseo;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getDireccion(){
        return this.direccion;
    }

    public Double getLongitud(){
        return this.longitud;
    }

    public Double getLatitud(){
        return this.latitud;
    }

    public String getTelefono(){
        return this.telefono;
    }

    public Cuenta getCuenta(){
        return this.cuenta;
    }
    public List<Grupo> getGrupos(){
        return this.grupos;
    }
    public Set<Modelo> getModelos(){
        return this.modelos;
    }
    public Set<Multimedia> getMultimedia(){
        return this.multimedia;
    }
    public Set<Target> getTargets(){
        return this.targets;
    }
    public Set<Componente> getComponentes(){
        return this.componentes;
    }
    //Setters

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public void setLatitud(Double latitud){
        this.latitud = latitud;
    }

    public void setLongitud(Double longitud){
        this.longitud = longitud;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public void setCuenta(Cuenta cuenta){
        this.cuenta = cuenta;
    }
    public void setGrupos(List<Grupo> grupos){
        this.grupos = grupos;
    }
    public void setModelos(Set<Modelo> modelos){
        this.modelos = modelos;
    }
    public void setMultimedia(Set<Multimedia> multimedia){
        this.multimedia = multimedia;
    }
    public void setTarget(Set<Target> targets){
        this.targets = targets;
    }
    public void setComponentes(Set<Componente> componentes){
        this.componentes = componentes;
    }

    //Metodos extras
    public void addComponente(Componente c){
        this.componentes.add(c);
    }
    public void removeComponente(Componente c){
        this.componentes.remove(c);
    }
}
