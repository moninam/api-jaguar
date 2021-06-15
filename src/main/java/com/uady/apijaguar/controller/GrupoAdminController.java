package com.uady.apijaguar.controller;

import java.util.List;

import javax.validation.Valid;

import com.uady.apijaguar.dto.DeleteDto;
import com.uady.apijaguar.dto.GrupoRequestDto;
import com.uady.apijaguar.dto.GrupoUpdateDto;
import com.uady.apijaguar.model.Grupo;
import com.uady.apijaguar.service.GrupoAdminService;
import com.uady.apijaguar.service.GrupoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class GrupoAdminController {
    @Autowired
    GrupoService grupoService;

    @Autowired
    GrupoAdminService grupoAdminService;

    @GetMapping("/grupos/{id}")
    public ResponseEntity<List<Grupo>> getGruposByIdMuseo(@PathVariable Integer id){
        List<Grupo> grupos = grupoService.getGruposByIdMuseo(id);

        return ResponseEntity.status(HttpStatus.OK).body(grupos);
    }
    @PostMapping("/grupo")
    public ResponseEntity<Grupo> createGrupo(@Valid @RequestBody GrupoRequestDto request){
        Grupo grupo = grupoAdminService.createGrupo(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(grupo);
    }

    @PutMapping("/grupo/{id}")
    public ResponseEntity<Grupo> updateGrupo(@PathVariable Integer id,
                            @Valid @RequestBody GrupoUpdateDto request)
    {
        Grupo grupo = grupoAdminService.updateGrupo(request, id);

        return ResponseEntity.status(HttpStatus.OK).body(grupo);
    }
    @DeleteMapping("/grupo/{id}")
    public ResponseEntity<DeleteDto> deleteGrupo(@PathVariable Integer id){
        DeleteDto delete = grupoAdminService.deleteGrupo(id);

        return ResponseEntity.status(HttpStatus.OK).body(delete);
    }
    

}
