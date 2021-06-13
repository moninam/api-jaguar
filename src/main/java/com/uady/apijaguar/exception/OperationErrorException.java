package com.uady.apijaguar.exception;

import com.uady.apijaguar.util.Constantes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class OperationErrorException extends RuntimeException {

    public OperationErrorException() {
        super(Constantes.GENERAL_ERROR);
    }

    public OperationErrorException(String mensaje) {
        super(mensaje);
    }
    
}