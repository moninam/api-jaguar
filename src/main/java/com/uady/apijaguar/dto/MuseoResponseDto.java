package com.uady.apijaguar.dto;

public class MuseoResponseDto {
    private Integer idMuseo;

    private String nameMuseo;

    private String telefono;

    private String direccion;

    public MuseoResponseDto(Integer idMuseo, String nameMuseo, String telefono, String direccion){
        this.idMuseo = idMuseo;
        this.nameMuseo = nameMuseo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    //GETTERS
    public Integer getIdMuseo(){
        return this.idMuseo;
    }
    public String getNameMuseo(){
        return this.nameMuseo;
    }
    public String getTelefono(){
        return this.telefono;
    }
    public String getDireccion(){
        return this.direccion;
    }

    //SETTERS
    public void setIdMuseo(Integer idMuseo){
        this.idMuseo = idMuseo;
    }
    public void setNameMuseo(String nameMuseo){
        this.nameMuseo = nameMuseo;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
}
