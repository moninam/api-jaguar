package com.uady.apijaguar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.uady.apijaguar.model.Marcador;
import com.uady.apijaguar.service.MarcadoresService;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class MarcadoresController {

    @Autowired
    private MarcadoresService marcadoresService;

    private Logger logger = LogManager.getLogger(this.getClass());

    @GetMapping("/marcadores")
    public ResponseEntity<List<Marcador>> getMarcadores(){
        List<Marcador> marcadores = marcadoresService.getMarcadores();

        return ResponseEntity.status(HttpStatus.OK).body(marcadores);
    }
    
}
