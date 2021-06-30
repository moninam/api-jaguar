package com.uady.apijaguar.security.jwt;

import java.io.IOException;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uady.apijaguar.dto.ErrorDto;
import com.uady.apijaguar.exception.NotFoundException;
import com.uady.apijaguar.service.CuentaDetailsImpl;
import com.uady.apijaguar.service.CuentaService;
import com.uady.apijaguar.util.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JwtTokenFilter extends OncePerRequestFilter{

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    CuentaService cuentaService;

    @Autowired
    CuentaDetailsImpl cuentaDetailServiceImpl;

    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                    HttpServletResponse response, FilterChain filterChain)
                    throws ServletException, IOException 
    {
        try{
            String token = getToken(request);

            if (token != null && jwtProvider.validateToken(token)){
                String alias = jwtProvider.getAliasFromToken(token);
              
                UserDetails userDetails = cuentaDetailServiceImpl.loadUserByUsername(alias);
                UsernamePasswordAuthenticationToken auth = 
                        new UsernamePasswordAuthenticationToken(
                            userDetails,null,
                            userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
                
            }
            
        }catch(NotFoundException exc){
            logger.error(exc.getMessage());
            sendErrorMessage(404,exc.getMessage(), response);
        }catch(Exception ex){
            ex.printStackTrace();
            logger.error("Fallo en el metodo DoFilter" + ex.getMessage());
            sendErrorMessage(400,Constantes.DO_FILTER_ERROR, response);
        }
        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request){
        String header = request.getHeader(Constantes.HEADER);
        
        if(header != null && header.startsWith(Constantes.BEARER)){
            return header.replace(Constantes.BEARER, "");
        }
        return null;
    }


    private void sendErrorMessage(int code, String message, HttpServletResponse response)
      throws ServletException, IOException {
        ErrorDto errorResponse = new ErrorDto();
        errorResponse.setCode(code);
        errorResponse.setMessage(message);

        byte[] responseToSend = restResponseBytes(errorResponse);
        ((HttpServletResponse) response).setHeader("Content-Type", "application/json");
        ((HttpServletResponse) response).setStatus(code);
        response.getOutputStream().write(responseToSend);
    }

    private byte[] restResponseBytes(ErrorDto eErrorResponse) throws IOException {
        String serialized = new ObjectMapper().writeValueAsString(eErrorResponse);
        return serialized.getBytes();
    }
    
}
