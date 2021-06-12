package com.uady.apijaguar.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import com.uady.apijaguar.model.Museo;
import com.uady.apijaguar.model.request.MuseoRequest;
import com.uady.apijaguar.service.MuseoService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class MuseoController {
    @Autowired
    private MuseoService museoService;

    private Logger logger = LogManager.getLogger(this.getClass());

    //POST /museo
    @PostMapping("/museo")
    public ResponseEntity<Museo> saveMuseo(@Valid @RequestBody MuseoRequest request) 
    throws URISyntaxException 
    {
        Museo museo = museoService.crearMuseo(request);
        
        return ResponseEntity
                .created(new URI("/museo/" + museo.getId()))
                .body(museo);
    }
}
