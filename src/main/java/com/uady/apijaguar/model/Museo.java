package com.uady.apijaguar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "museo")
public class Museo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idMuseo")
    private Integer idMuseo;

    @Column(name="ubicacion")
    private String ubicacion;

    @Column(name="direccion")
    private String direccion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name="telefono")
    private String telefono;

    @OneToOne
    @JoinColumn(name = "idCuenta", referencedColumnName = "idCuenta")
    private Cuenta cuenta;

    public Museo(String nombre, String ubicacion,String direccion, String telefono, Cuenta cuenta){
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.direccion = direccion;
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

    public String getUbicacion(){
        return this.ubicacion;
    }

    public String getDireccion(){
        return this.direccion;
    }


    public String getTelefono(){
        return this.telefono;
    }

    public Cuenta getCuenta(){
        return this.cuenta;
    }

    //Setters

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public void setCuenta(Cuenta cuenta){
        this.cuenta = cuenta;
    }
    

    
}
