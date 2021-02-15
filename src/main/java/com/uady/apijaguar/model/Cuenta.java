package com.uady.apijaguar.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cuenta")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcuenta")
    private Integer idCuenta;

    @Column(name="email")
    private String email;

    @Column(name="password")
    @JsonIgnore
    private String password;

    @Column(name="token")
    @JsonIgnore
    private String token;

    @Column(name="isbanned")
    private Boolean isBanned;

    @Column(name="registerdate")
    private Date registerDate;

    @Column(name="lastupdate")
    private Date lastUpdate;

    public Cuenta(){}

    public Cuenta(String email, String password, String token, Boolean isBanned, Date registerDate, Date lastUpdate){
        this.email = email;
        this.password = password;
        this.token = token;
        this.isBanned = isBanned;
        this.registerDate = registerDate;
        this.lastUpdate = lastUpdate;
    }

    public Integer getIdCuenta(){
        return this.idCuenta;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public String getToken(){
        return this.token;
    }

    public Boolean isBanned(){
        return this.isBanned;
    }

    public Date getRegisterDate(){
        return this.registerDate;
    }

    public Date getLastUpdate(){
        return this.lastUpdate;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setToken(String token){
        this.token = token;
    }

    public void setIsBanned(Boolean isBanned){
        this.isBanned = isBanned;
    }

    public void setRegisterDate(Date registerDate){
        this.registerDate = registerDate;
    }

    public void setLastUpdate(Date lastUpdate){
        this.lastUpdate = lastUpdate;
    }
    
}
