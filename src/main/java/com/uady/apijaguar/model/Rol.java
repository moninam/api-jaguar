package com.uady.apijaguar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.uady.apijaguar.enums.RolNombre;

@Entity
@Table(name="rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_rol")
    private Integer idRol;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="rol_nombre")
    private RolNombre rolNombre;

    public Rol(@NotNull RolNombre rolNombre){
        this.rolNombre = rolNombre;
    }

    public Rol(){}

    //GETTERS
    public Integer getId(){
        return this.idRol;
    }

    public RolNombre getRolNombre(){
        return this.rolNombre;
    }

    //SETTERS
    public void setRolNombre(RolNombre rolnombre){
        this.rolNombre = rolnombre;
    }
}
