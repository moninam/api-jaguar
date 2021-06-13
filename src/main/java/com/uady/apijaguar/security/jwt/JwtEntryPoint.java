package com.uady.apijaguar.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uady.apijaguar.util.Constantes;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse resp, 
    AuthenticationException exc) throws IOException, ServletException 
    {
        logger.error("Error en el metodo commence");
        resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,Constantes.ACCES_NOT_GRANTED);
    }
    
}

