package com.uady.apijaguar.dto;

import javax.validation.constraints.NotBlank;

public class LoginDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    //Getters
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }

    //Setters
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
}
