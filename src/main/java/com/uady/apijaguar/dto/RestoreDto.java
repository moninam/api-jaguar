package com.uady.apijaguar.dto;

import javax.validation.constraints.NotBlank;

public class RestoreDto {
    @NotBlank
    private String username;
    @NotBlank
    private String oldPassword;
    @NotBlank
    private String nuevaPassword;
    @NotBlank
    private String confirmPassword;

    //GETTERS
    public String getUsername(){
        return this.username;
    }
    public String getOldPassword(){
        return this.oldPassword;
    }
    public String getNuevaPassword(){
        return this.nuevaPassword;
    }
    public String getConfirmPassword(){
        return this.confirmPassword;
    }

    //SETTERS
    public void setUsername(String username){
        this.username = username;
    }
    public void setOldPassword(String oldPassword){
        this.oldPassword = oldPassword;
    }
    public void setNuevaPassword(String nPassword){
        this.nuevaPassword = nPassword;
    }
    public void setConfirmPassword(String confirmPassword){
        this.confirmPassword = confirmPassword;
    }
}
