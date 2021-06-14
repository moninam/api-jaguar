package com.uady.apijaguar.controller;

import javax.validation.Valid;

import com.uady.apijaguar.dto.MuseoResponseDto;
import com.uady.apijaguar.dto.UbicacionDto;
import com.uady.apijaguar.model.Museo;
import com.uady.apijaguar.service.UbicacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/visor/location")
@CrossOrigin
public class LocationController {
    
    @Autowired
    UbicacionService locationService;

    @PostMapping("/museo")
    public ResponseEntity<MuseoResponseDto> getMuseo(@Valid @RequestBody UbicacionDto request){
        MuseoResponseDto museo = locationService.getNearestLocation(request);

        if (museo == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(museo);
    }
}
