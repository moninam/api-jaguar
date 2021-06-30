package com.uady.apijaguar.controller;

import java.util.Set;

import javax.validation.Valid;

import com.uady.apijaguar.dto.DeleteDto;
import com.uady.apijaguar.dto.TargetRequestDto;
import com.uady.apijaguar.dto.TargetUpdateDto;
import com.uady.apijaguar.model.Target;
import com.uady.apijaguar.service.TargetService;

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
public class TargetController {
    @Autowired
    TargetService targetService;

    @GetMapping("/targets/{id}")
    public ResponseEntity<Set<Target>> getTargetsByMuseo(@PathVariable Integer id){
        Set<Target> targets = targetService.getTargetByIdMuseo(id);

        return ResponseEntity.status(HttpStatus.OK).body(targets);
    }
    @PostMapping("/target")
    public ResponseEntity<Target> createTarget(@Valid @RequestBody TargetRequestDto request){
        Target target = targetService.createTarget(request);

        return ResponseEntity.status(HttpStatus.OK).body(target);    
    }

    @PutMapping("/target/{id}")
    public ResponseEntity<Target> updateTarget(@Valid @RequestBody TargetUpdateDto request, @PathVariable Integer id){
        Target target = targetService.updateTarget(request, id);

        return ResponseEntity.status(HttpStatus.OK).body(target);
    }

    @DeleteMapping("/target/{id}")
    public ResponseEntity<DeleteDto> deleteTarget(@PathVariable Integer id,@RequestParam(name = "id") Integer museoId){
        DeleteDto delete = targetService.deleteTarget(id, museoId);

        return ResponseEntity.status(HttpStatus.OK).body(delete);
    }
}
