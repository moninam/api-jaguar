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
    @Column(name="idmuseo")
    private Integer idMuseo;

    @Column(name = "nombremuseo")
    private String nombreMuseo;

    @Column(name="urllocalizacion")
    private String urlLocalizacion;

    @Column(name="telefono")
    private String telefono;

    @OneToOne
    @JoinColumn(name = "idcuenta", referencedColumnName = "idcuenta")
    private Cuenta cuenta;

    public Museo(String nombreMuseo, String urlLocalizacion, String telefono, Cuenta cuenta){
        this.nombreMuseo = nombreMuseo;
        this.urlLocalizacion = urlLocalizacion;
        this.telefono = telefono;
        this.cuenta = cuenta;
    }

    public Museo(){}

    public String getNombreMuseo(){
        return this.nombreMuseo;
    }

    public String getUrlLocalizacion(){
        return this.urlLocalizacion;
    }

    public String getTelefono(){
        return this.telefono;
    }

    public Cuenta getCuenta(){
        return this.cuenta;
    }

    public void setNombreMuseo(String nombreMuseo){
        this.nombreMuseo = nombreMuseo;
    }

    public void setUrlLocalizacion(String urlLocalizacion){
        this.urlLocalizacion = urlLocalizacion;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public void setCuenta(Cuenta cuenta){
        this.cuenta = cuenta;
    }

    
}
