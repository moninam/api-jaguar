package com.uady.apijaguar.controller;

import java.util.Set;

import javax.validation.Valid;

import com.uady.apijaguar.dto.ComponenteRequestDto;
import com.uady.apijaguar.dto.ComponenteUpdateDto;
import com.uady.apijaguar.dto.DeleteDto;
import com.uady.apijaguar.model.Componente;
import com.uady.apijaguar.model.Grupo;
import com.uady.apijaguar.service.ComponenteAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ComponenteAdminController {
    @Autowired
    ComponenteAdminService componenteService;

    @GetMapping("/componentes/{id}")
    public ResponseEntity<Set<Componente>> getComponentesByIdMuseo(@PathVariable Integer id){
        Set<Componente> componentes = componenteService.getComponentesByIdMuseo(id);

        return ResponseEntity.status(HttpStatus.OK).body(componentes);
    }
    @PostMapping("/componente")
    public ResponseEntity<Componente> createComponente(@Valid @RequestBody ComponenteRequestDto request) {
        Componente componente = componenteService.createComponente(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(componente);
    }
    @PutMapping("/componente/{id}")
    public ResponseEntity<Componente> updateComponente(@Valid @RequestBody ComponenteUpdateDto request, @PathVariable Integer id){
        Componente componente = componenteService.updateComponente(request, id);

        return ResponseEntity.status(HttpStatus.OK).body(componente);
    }

    @DeleteMapping("/componente/{id}")
    public ResponseEntity<DeleteDto> deleteComponente(@PathVariable Integer id,@RequestParam(name = "id") Integer museoId){
        DeleteDto delete = componenteService.deleteComponente(id, museoId);

        return ResponseEntity.status(HttpStatus.OK).body(delete);
    }
    @GetMapping("/componente/{id}/grupo")
    public ResponseEntity<Grupo> findGrupoByComponent(@PathVariable Integer id){
        Grupo grupo = componenteService.findGrupoByComponente(id);

        return ResponseEntity.status(HttpStatus.OK).body(grupo);
    }
}
