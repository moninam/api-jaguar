package com.uady.apijaguar.exception;

import com.uady.apijaguar.util.Constantes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class OldPasswordWrongException extends RuntimeException {

    public OldPasswordWrongException() {
        super(Constantes.GENERAL_ERROR);
    }

    public OldPasswordWrongException(String mensaje) {
        super(mensaje);
    }
    
}