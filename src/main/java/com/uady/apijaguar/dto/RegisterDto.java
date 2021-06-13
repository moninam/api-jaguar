package com.uady.apijaguar.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class RegisterDto {
    @Email
    private String email;

    @NotBlank
    private String alias;

    @NotBlank
    private String password;

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
}
