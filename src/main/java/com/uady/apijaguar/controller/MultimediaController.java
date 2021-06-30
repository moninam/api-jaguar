package com.uady.apijaguar.controller;

import java.util.Set;

import javax.validation.Valid;

import com.uady.apijaguar.dto.DeleteDto;
import com.uady.apijaguar.dto.MultimediaRequestDto;
import com.uady.apijaguar.dto.MultimediaUpdateDto;
import com.uady.apijaguar.model.Multimedia;
import com.uady.apijaguar.service.MultimediaService;

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
public class MultimediaController {
    @Autowired
    MultimediaService multimediaService;

    @GetMapping("/multimedias/{id}")
    public ResponseEntity<Set<Multimedia>> getMultimediaByIdMuseo(@PathVariable Integer id){
        Set<Multimedia> multimedias = multimediaService.getMultimediaByIdMuseo(id);

        return ResponseEntity.status(HttpStatus.OK).body(multimedias);
    }
    @PostMapping("/multimedia")
    public ResponseEntity<Multimedia> createMultimedia(@Valid @RequestBody MultimediaRequestDto request){
        Multimedia multimedia = multimediaService.createMultimedia(request);

        return ResponseEntity.status(HttpStatus.OK).body(multimedia);    
    }

    @PutMapping("/multimedia/{id}")
    public ResponseEntity<Multimedia> updateMultimedia(@Valid @RequestBody MultimediaUpdateDto request, @PathVariable Integer id){
        Multimedia multimedia = multimediaService.updateMultimedia(request, id);

        return ResponseEntity.status(HttpStatus.OK).body(multimedia);
    }

    @DeleteMapping("/multimedia/{id}")
    public ResponseEntity<DeleteDto> deleteMultimedia(@PathVariable Integer id,@RequestParam(name = "id") Integer museoId){
        DeleteDto delete = multimediaService.deleteMultimedia(id, museoId);

        return ResponseEntity.status(HttpStatus.OK).body(delete);
    }
}
