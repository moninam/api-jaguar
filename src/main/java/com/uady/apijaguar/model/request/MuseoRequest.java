package com.uady.apijaguar.model.request;

import com.uady.apijaguar.enums.ComponentType;
import com.uady.apijaguar.util.Constantes;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MuseoRequest {
    @NotEmpty(message=Constantes.EMPTY_UB)
    public String direccion;

    @NotEmpty(message =Constantes.EMPTY_PHONE)
    @Size(min = 1, max = 10)
    public String telefono;

    @NotNull(message=Constantes.EMPTY_LAT)
    public Double latitud;

    @NotNull(message = Constantes.EMPTY_LONG)
    public Double longitud;

    @NotEmpty(message =Constantes.EMPTY_NAME)
    public String nombre;

    @NotNull(message = Constantes.EMPTY_ACCOUNT)
    @Min(value=1,message= Constantes.NOT_VALID_ACCOUNT)
    public Integer idCuenta;

    public MuseoRequest(String direccion, String telefono,Double latitud,
        Double longitud,String nombre, Integer idCuenta)
    {
        this.direccion = direccion;
        this.telefono = telefono;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombre = nombre;
        this.idCuenta = idCuenta;
    }

    public MuseoRequest(){}

    //Getters
    public String getTelefono(){
        return this.telefono;
    }

    public String getDireccion(){
        return this.direccion;
    }

    public String getName(){
        return this.nombre;
    }

    public Integer getIdCuenta(){
        return this.idCuenta;
    }

    public Double getLatitud(){
        return this.latitud;
    }

    public Double getLongitud(){
        return this.longitud;
    }

    //Setters
    

    public void setTeletono(String telefono){
        this.telefono = telefono;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public void setName(String name){
        this.nombre = name;
    }

    public void setIdCuenta(Integer idCuenta){
        this.idCuenta = idCuenta;
    }
    
    public void setLatitud(Double latitud){
        this.latitud = latitud;
    }

    public void setLongitud(Double longitud){
        this.longitud = longitud;
    }


}
