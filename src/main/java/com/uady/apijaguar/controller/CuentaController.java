package com.uady.apijaguar.controller;

import javax.validation.Valid;

import com.uady.apijaguar.dto.Mensaje;
import com.uady.apijaguar.dto.RestoreDto;
import com.uady.apijaguar.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
