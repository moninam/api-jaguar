package com.uady.apijaguar.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import com.uady.apijaguar.dto.DeleteDto;
import com.uady.apijaguar.dto.ModeloRequestDto;
import com.uady.apijaguar.dto.ModeloUpdateDto;
import com.uady.apijaguar.model.Modelo;
import com.uady.apijaguar.service.ModeloService;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ModeloController {
    @Autowired
    ModeloService modeloService;

    @GetMapping("/modelos/{id}")
    public ResponseEntity<Set<Modelo>> getModelosByIdMuseo(@PathVariable Integer id){
        Set<Modelo> modelos = modeloService.getModelosByIdMuseo(id);

        return ResponseEntity.status(HttpStatus.OK).body(modelos);
    }
    @PostMapping("/modelo")
    public ResponseEntity<Modelo> createModelo(@Valid @RequestBody ModeloRequestDto request){
        Modelo modelo = modeloService.createModelo(request);

        return ResponseEntity.status(HttpStatus.OK).body(modelo);
    }

    @PutMapping("/modelo/{id}")
    public ResponseEntity<Modelo> updateModelo(@Valid @RequestBody ModeloUpdateDto request, @PathVariable Integer id){
        Modelo modelo = modeloService.updateModelo(request, id);

        return ResponseEntity.status(HttpStatus.OK).body(modelo);
    }

    @DeleteMapping("/modelo/{id}")
    public ResponseEntity<DeleteDto> deleteModelo(@PathVariable Integer id,@RequestParam(name = "id") Integer museoId){
        DeleteDto delete = modeloService.deleteModelo(id, museoId);

        return ResponseEntity.status(HttpStatus.OK).body(delete);
    }
}
