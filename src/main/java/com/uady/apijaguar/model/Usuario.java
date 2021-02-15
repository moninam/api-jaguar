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
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idusuario")
    private Integer idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name="direccion")
    private String direccion;

    @OneToOne
    @JoinColumn(name = "idcuenta", referencedColumnName = "idcuenta")
    private Cuenta cuenta;

    public Usuario(String nombre, String telefono, String direccion, Cuenta cuenta){
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cuenta = cuenta;
    }

    public Usuario(){}
    
    public String getNombre(){
        return this.nombre;
    }

    public String getTelefono(){
        return this.telefono;
    }

    public String getDireccion(){
        return this.direccion;
    }

    public Cuenta getCuenta(){
        return this.cuenta;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public void setCuenta(Cuenta cuenta){
        this.cuenta = cuenta;
    }
}
