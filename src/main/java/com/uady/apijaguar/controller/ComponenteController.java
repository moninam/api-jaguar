package com.uady.apijaguar.controller;

import java.util.List;

import com.uady.apijaguar.model.Componente;
import com.uady.apijaguar.service.ComponenteService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ComponenteController {
    @Autowired
    private ComponenteService componenteService;

    private Logger logger = LogManager.getLogger(this.getClass());

    @GetMapping("/componente")
    public ResponseEntity<List<Componente>> getGruposByMuseo(){
        
        List<Componente> componente = componenteService.getComponentes();
        return ResponseEntity.status(HttpStatus.OK).body(componente);
    }
}
