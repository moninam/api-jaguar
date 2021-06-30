package com.uady.apijaguar.dto;


public class JwtDto {
    private String token;

    public JwtDto(String token)
    {
        this.token = token;
    }
    public JwtDto(){}

    //Getters
    public String getToken(){
        return this.token;
    }
   
    //Setters
    public void setToken(String token){
        this.token = token;
    }
}
