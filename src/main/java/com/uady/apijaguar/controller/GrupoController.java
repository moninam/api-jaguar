package com.uady.apijaguar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.uady.apijaguar.model.Grupo;
import com.uady.apijaguar.model.GrupoModelo;
import com.uady.apijaguar.service.GrupoService;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class GrupoController {
    @Autowired
    private GrupoService grupoService;

    private Logger logger = LogManager.getLogger(this.getClass());
    
    @GetMapping("/grupos/{id}")
    public ResponseEntity<List<Grupo>> getGruposByMuseo(@PathVariable Integer id){
        
        List<Grupo> grupos = grupoService.getGruposByIdMuseo(id);

        return ResponseEntity.status(HttpStatus.OK).body(grupos);
    }

    @GetMapping("/grupos_modelos/{id}")
    public ResponseEntity<List<GrupoModelo>> getModelosByIdGrupo(@PathVariable Integer id){
        List<GrupoModelo> grupos = grupoService.getModelosByGrupo(id);

        return ResponseEntity.status(HttpStatus.OK).body(grupos);
    }

}
