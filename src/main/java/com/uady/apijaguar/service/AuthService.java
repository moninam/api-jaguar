package com.uady.apijaguar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import java.text.ParseException;
import com.uady.apijaguar.dto.JwtDto;
import com.uady.apijaguar.dto.LoginDto;
import com.uady.apijaguar.dto.RegisterDto;
import com.uady.apijaguar.enums.RolNombre;
import com.uady.apijaguar.exception.InvalidOperationException;
import com.uady.apijaguar.exception.OperationErrorException;
import com.uady.apijaguar.model.Cuenta;
import com.uady.apijaguar.model.Rol;
import com.uady.apijaguar.security.jwt.JwtProvider;
import com.uady.apijaguar.util.Constantes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
@Transactional
public class AuthService {
    @Autowired
    CuentaService cuentaService;

    @Autowired
    RolService rolService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;

    private Logger logger = LogManager.getLogger(this.getClass());

    public Cuenta createAccount(RegisterDto nuevoUsuario,PasswordEncoder passwordEncoder){
        if (cuentaService.existsByAlias(nuevoUsuario.getAlias())){
            throw new InvalidOperationException(Constantes.ACCOUNT_ALREADY_EXIST);
        }

        if (cuentaService.existsByEmail(nuevoUsuario.getEmail())){
            throw new InvalidOperationException(Constantes.EMAIL_ALREADY_EXIST);
        }

        try{
            String secret = UUID.randomUUID().toString();
            Boolean isBanned = false;
            Date currentDate = new Date();
            Date lastUpdate = new Date();

            Cuenta cuenta = new Cuenta(
                                nuevoUsuario.getEmail(),
                                nuevoUsuario.getAlias(),
                                passwordEncoder.encode(nuevoUsuario.getPassword()),
                                secret,
                                isBanned,
                                currentDate,
                                lastUpdate);
            Set<Rol> roles = new HashSet<>();
            roles.add(rolService.getByRolNombre(RolNombre.ROL_USER).get());
            
            if(nuevoUsuario.getRoles().contains("admin")){
                roles.add(rolService.getByRolNombre(RolNombre.ROL_ADMIN).get());
            }
            cuenta.setRol(roles);
            cuentaService.save(cuenta);

            return cuenta;
        } catch(Exception exc){
            logger.error(exc);
            exc.printStackTrace();
            //logger.error("Error: {}", exc.getMessage());
            throw new OperationErrorException(Constantes.ACCOUNT_ERROR);
        }
        
    }

    public JwtDto login(LoginDto loginUsuario){
        try{
            Authentication auth = authenticationManager
                            .authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getUsername(), loginUsuario.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(auth);
            String jwt = jwtProvider.generateToken(auth);
            JwtDto jwtDto = new JwtDto(jwt);

            return jwtDto;
        } catch(Exception exc){
            exc.printStackTrace();
            logger.error(exc);
            throw new OperationErrorException(Constantes.LOGIN_ERROR);
        }
    }
    public JwtDto refreshToken(JwtDto token){
        try{
            String tokenNuevo = jwtProvider.refreshToken(token);
            JwtDto jwt = new JwtDto(tokenNuevo);

            return jwt;
        } catch(ParseException exc){
            logger.error(exc.getMessage());
            exc.printStackTrace();
            throw new OperationErrorException(Constantes.NEW_TOKEN_ERROR);
        }
    }

}
