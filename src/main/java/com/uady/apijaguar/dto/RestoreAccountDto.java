package com.uady.apijaguar.dto;

import javax.validation.constraints.NotBlank;

public class RestoreAccountDto {

    @NotBlank
    private String email;

    //GETTERS AND SETTERS
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
}
