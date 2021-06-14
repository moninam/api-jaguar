package com.uady.apijaguar.controller;

import java.util.List;
import java.util.Set;

import com.uady.apijaguar.model.Grupo;
import com.uady.apijaguar.model.Componente;
import com.uady.apijaguar.service.GrupoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/visor")
@CrossOrigin
public class GrupoController {
    @Autowired
    GrupoService grupoService;

    @GetMapping("/grupo/{id}")
    public ResponseEntity<List<Grupo>> getGruposByIdMuseo(@PathVariable Integer id){
        List<Grupo> grupos = grupoService.getGruposByIdMuseo(id);

        return ResponseEntity.status(HttpStatus.OK).body(grupos);
    }

    @GetMapping("/grupo/{id}/componentes")
    public ResponseEntity<Set<Componente>> getComponentesByIdGrupo(@PathVariable Integer id){
        Set<Componente> componentes = grupoService.getComponentesByIdGrupo(id);

        return ResponseEntity.status(HttpStatus.OK).body(componentes);
    }
}
