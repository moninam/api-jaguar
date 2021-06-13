package com.uady.apijaguar.controller;

import javax.validation.Valid;

import com.uady.apijaguar.dto.JwtDto;
import com.uady.apijaguar.dto.LoginDto;
import com.uady.apijaguar.dto.Mensaje;
import com.uady.apijaguar.dto.RegisterDto;
import com.uady.apijaguar.model.Cuenta;
import com.uady.apijaguar.security.jwt.JwtProvider;
import com.uady.apijaguar.service.AuthService;
import com.uady.apijaguar.service.CuentaService;
import com.uady.apijaguar.service.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AuthService authService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/register")
    public ResponseEntity<?> nuevo(@Valid @RequestBody RegisterDto nuevoUsuario,
                            BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Mensaje("Error en los campos ingresados"),HttpStatus.BAD_REQUEST);
        }

        Cuenta cuenta = authService.createAccount(nuevoUsuario, passwordEncoder);
        
        if (cuenta == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(cuenta);
    }
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginDto loginUsuario,
                                    BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()){
            return new ResponseEntity(new Mensaje("Error en los campos ingresados"),HttpStatus.BAD_REQUEST);
        }

        JwtDto jwtDto = authService.login(loginUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(jwtDto);
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtDto> refresh(@RequestBody JwtDto jwtDto){
        JwtDto tokenNuevo = authService.refreshToken(jwtDto);

        return ResponseEntity.status(HttpStatus.OK).body(tokenNuevo);
    }

}
