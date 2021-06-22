package com.uady.apijaguar.dto;

public class InformationDto {
    private Integer idMuseo;
    
    public InformationDto(Integer museo){
        this.idMuseo = museo;
    }

    public InformationDto(){}

    public Integer getIdMuseo(){
        return this.idMuseo;
    }
    public void setIdMuseo(Integer idMuseo){
        this.idMuseo = idMuseo;
    }
    
}
