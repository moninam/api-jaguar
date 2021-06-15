package com.uady.apijaguar.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.uady.apijaguar.util.Constantes;

public class RegisterDto {
    @Email(message=Constantes.EMAIL_ERROR_FORMAT)
    private String email;

    @NotEmpty(message=Constantes.EMPTY_ALIAS)
    private String alias;

    @NotEmpty(message=Constantes.EMPTY_PASSWORD)
    private String password;

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

    private Set<String> roles = new HashSet<>();

    //Getters
    public String getEmail(){
        return this.email;
    }
    public String getAlias(){
        return this.alias;
    }
    public String getPassword(){
        return this.password;
    }
    public Set<String> getRoles(){
        return this.roles;
    }
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

    //Setters
    public void setEmail(String email){
        this.email = email;
    }
    public void setAlias(String alias){
        this.alias = alias;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setRoles(Set<String> roles){
        this.roles = roles;
    }
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
