package com.uady.apijaguar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contenido_extra")
public class ContenidoExtra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcontenido")
    private Integer idContenido;

    @Column(name="texto")
    private String texto;

    @Column(name="urlimagen")
    private String urlImagen;

    @Column(name="urlvideo")
    private String urlVideo;

    public ContenidoExtra(String texto,String urlImagen, String urlVideo){
        this.texto = texto;
        this.urlImagen =urlImagen;
        this.urlVideo = urlVideo;
    }

    public ContenidoExtra(){}

    public Integer getIdContenido(){
        return this.idContenido;
    }

    public String getTexto(){
        return this.texto;
    }

    public String getUrlImagen(){
        return this.urlImagen;
    }

    public String getUrlVideo(){
        return this.urlVideo;
    }

    public void setTexto(String texto){
        this.texto = texto;
    }

    public void setUrlImagen(String urlImagen){
        this.urlImagen = urlImagen;
    }

    public void setUrlVideo(String urlVideo){
        this.urlVideo = urlVideo;
    }
    
}
