package com.uady.apijaguar.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.uady.apijaguar.util.Constantes;

public class AccountInformationDto {
    @NotEmpty(message=Constantes.EMPTY_DIRECTION)
    private String direccion;

    @NotEmpty(message=Constantes.EMPTY_TELEFONO)
    private String telefono;

    @NotNull(message=Constantes.EMPTY_LATITUD)
    private Double latitud;

    @NotNull(message=Constantes.EMPTY_LONGITUD)
    private Double longitud;
    
    @NotEmpty(message=Constantes.EMPTY_NOMBRE)
    private String nombre;

    public AccountInformationDto(String direccion,
                                String telefono,
                                Double latitud,
                                Double longitud,
                                String nombre)
    {
        this.direccion = direccion;
        this.telefono = telefono;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombre = nombre;
    }
    public AccountInformationDto(){}
    //GETTERS
    public String getDireccion(){
        return this.direccion;
    }
    public String getTelefono(){
        return this.telefono;
    }
    public Double getLatitud(){
        return this.latitud;
    }
    public Double getLongitud(){
        return this.longitud;
    }
    public String getNombre(){
        return this.nombre;
    }
    //SETTERS
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    public void setLatitud(Double latitud){
        this.latitud = latitud;
    }
    public void setLongitud(Double longitud){
        this.longitud = longitud;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
