package com.uady.apijaguar.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cuenta")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCuenta")
    private Integer idCuenta;

    @Column(name="email")
    private String email;

    @Column(name="alias")
    private String alias;

    @Column(name="password")
    @JsonIgnore
    private String password;

    @Column(name="secret")
    @JsonIgnore
    private String secret;

    @Column(name="is_banned")
    private Boolean isBanned;

    @Column(name="register_date")
    private Date registerDate;

    @Column(name="last_update")
    private Date lastUpdate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="cuenta_rol",joinColumns = @JoinColumn(name="id_cuenta"),
    inverseJoinColumns = @JoinColumn(name="id_rol"))
    private Set<Rol> roles = new HashSet<>();

    public Cuenta(){}

    public Cuenta(String email,String alias, String password, String token, Boolean isBanned, Date registerDate, Date lastUpdate){
        this.email = email;
        this.alias = alias;
        this.password = password;
        this.secret = token;
        this.isBanned = isBanned;
        this.registerDate = registerDate;
        this.lastUpdate = lastUpdate;
    }

    //Getters

    public Integer getIdCuenta(){
        return this.idCuenta;
    }

    public String getEmail(){
        return this.email;
    }

    public String getAlias(){
        return this.alias;
    }
    public String getPassword(){
        return this.password;
    }

    public String getSecret(){
        return this.secret;
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

    public Set<Rol> getRol(){
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

    public void setSecret(String token){
        this.secret = token;
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

    public void setRol(Set<Rol>roles){
        this.roles = roles;
    }
    
}
