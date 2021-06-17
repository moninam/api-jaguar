package com.uady.apijaguar.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.uady.apijaguar.enums.ComponentType;
import com.uady.apijaguar.util.Constantes;

public class ComponenteUpdateDto {
    @NotEmpty(message=Constantes.NOMBRE_EMPTY)
    private String nombre;
    
    @NotNull(message = Constantes.IDGRUPO_EMPTY)
    private Integer idGrupo;

    @NotEmpty(message=Constantes.DESCRIPCION_EMPTY)
    private String descripcion;

    @NotNull(message = Constantes.MARCADOR_EMPTY)
    private Integer idMarcador;

    @NotNull(message = Constantes.TIPO_COMPONENTE_EMPTY)
    @Enumerated(EnumType.STRING)
    private ComponentType tipoComponente;
    
    @NotNull(message = Constantes.IDELEMENTO_EMPTY)
    @Min(value=1,message= Constantes.IDELEMENTO_WRONG)
    private Integer idElemento;

    @NotEmpty(message=Constantes.URL_IMAGEN_EMPTY)
    private String urlImagen;

    @NotNull(message = Constantes.HAS_TARGET_INVALID)
    private Boolean hasTarget;

    @NotNull(message = Constantes.HAS_DESCRIPTION_INVALID)
    private Boolean hasDescription;

    //GETTER
    public String getNombre(){
        return this.nombre;
    }
    public Integer getIdGrupo(){
        return this.idGrupo;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public Integer getIdMarcador(){
        return this.idMarcador;
    }
    public ComponentType getTipoComponente(){
        return this.tipoComponente;
    }
    public Integer getIdElemento(){
        return this.idElemento;
    }
    public String getUrlImagen(){
        return this.urlImagen;
    }
    public Boolean getHasTarget(){
        return this.hasTarget;
    }
    public Boolean getHasDescription(){
        return this.hasDescription;
    }
    //SETTER
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setIdGrupo(Integer idGrupo){
        this.idGrupo = idGrupo;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void setMarcador(Integer idMarcador){
        this.idMarcador = idMarcador;
    }
    public void setTipoComponente(ComponentType tipoComponente){
        this.tipoComponente = tipoComponente;
    }
    public void setIdElemento(Integer idElemento){
        this.idElemento = idElemento;
    }
    public void setUrlImagen(String urlImagen){
        this.urlImagen = urlImagen;
    }
    public void setHasTarget(Boolean hasTarget){
        this.hasTarget = hasTarget;
    }
    public void setHasDescription(Boolean hasDescription){
        this.hasDescription = hasDescription;
    }
}
