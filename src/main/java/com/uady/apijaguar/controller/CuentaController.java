package com.uady.apijaguar.controller;

import javax.validation.Valid;

import com.uady.apijaguar.dto.AccountInformationDto;
import com.uady.apijaguar.dto.InformationDto;
import com.uady.apijaguar.dto.Mensaje;
import com.uady.apijaguar.dto.RestoreDto;
import com.uady.apijaguar.model.Museo;
import com.uady.apijaguar.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
@CrossOrigin
public class CuentaController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthService authService;

    @PostMapping("/restore")
    public ResponseEntity<?> restorePassword(@Valid @RequestBody RestoreDto request,
                            BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Mensaje("Error en los campos ingresados"),HttpStatus.BAD_REQUEST);
        }

        authService.restorePassword(request, passwordEncoder);

        return new ResponseEntity(new Mensaje("La contaseña se ha cambiado con exito"),HttpStatus.OK);
    }
    @GetMapping("/museo")
    public ResponseEntity<InformationDto> getIdMuseo(@RequestParam("name") String alias){
        InformationDto info = authService.getDataInformation(alias);
        return ResponseEntity.status(HttpStatus.OK).body(info);
    }
    @GetMapping("/profile")
    public ResponseEntity<AccountInformationDto> getAccountInfo(@RequestParam("alias")String alias){
        AccountInformationDto info = authService.getAccountInformation(alias);
        return ResponseEntity.status(HttpStatus.OK).body(info);
    }
    @PutMapping("/profile")
    public ResponseEntity<Museo> updateAccountInfo(@RequestParam("alias")String alias,@Valid @RequestBody AccountInformationDto info){
        Museo museo = authService.updateProfile(info, alias);

        return ResponseEntity.status(HttpStatus.OK).body(museo);
    }
}
