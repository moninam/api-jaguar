package com.uady.apijaguar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import java.text.ParseException;
import com.uady.apijaguar.dto.JwtDto;
import com.uady.apijaguar.dto.LoginDto;
import com.uady.apijaguar.dto.RegisterDto;
import com.uady.apijaguar.dto.RestoreAccountDto;
import com.uady.apijaguar.dto.RestoreDto;
import com.uady.apijaguar.enums.RolNombre;
import com.uady.apijaguar.exception.InvalidOperationException;
import com.uady.apijaguar.exception.NotFoundException;
import com.uady.apijaguar.exception.OldPasswordWrongException;
import com.uady.apijaguar.exception.OperationErrorException;
import com.uady.apijaguar.model.Cuenta;
import com.uady.apijaguar.model.Rol;
import com.uady.apijaguar.security.jwt.JwtProvider;
import com.uady.apijaguar.util.Constantes;
import com.uady.apijaguar.util.PasswordUtil;

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

    @Autowired
    EmailAccountSenderService senderService;

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

            senderService.sendRegisterEmail(cuenta.getEmail(), cuenta.getAlias());
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
        } catch(BadCredentialsException e){
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new InvalidOperationException(Constantes.BAD_CREDENTIALS);
        }catch(Exception exc){
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

    public void recoverPassword(Integer idCuenta, PasswordEncoder passwordEncoder){
        
        if(!cuentaService.existsByIdCuenta(idCuenta)){
            throw new NotFoundException(Constantes.ACCOUNT_NOT_FOUND);
        }

        try{
            Cuenta cuenta = cuentaService.findCuenta(idCuenta);
            String nPassword = PasswordUtil.generatePassword();
            String encoder = passwordEncoder.encode(nPassword);
            cuenta.setPassword(encoder);
            cuentaService.save(cuenta);
            senderService.sendRecoverEmail(nPassword, cuenta.getEmail());
        } catch(Exception e){
            logger.error(e);
            e.printStackTrace();
            throw new OperationErrorException(Constantes.RECOVER_PASSWORD_ERROR);
        }
    }

    public void restorePassword(RestoreDto request, PasswordEncoder passwordEncoder){
        Optional<Cuenta> cuentaOpt = cuentaService.getByAlias(request.getUsername());

        if (!cuentaOpt.isPresent()){
            throw new NotFoundException(Constantes.ENTITY_NOT_FOUND);
        }
        Cuenta cuenta = cuentaOpt.get();

        logger.info(cuenta.getPassword());
        
        if(!passwordEncoder.matches(request.getOldPassword(), cuenta.getPassword())){
            throw new OldPasswordWrongException(Constantes.OLD_PASS_WRONG);
        }

        if(!request.getNuevaPassword().equals(request.getConfirmPassword())){
            throw new OldPasswordWrongException(Constantes.PASS_NOT_SAME);
        }
        try{
            String encoder = passwordEncoder.encode(request.getNuevaPassword());
            cuenta.setPassword(encoder);
            cuentaService.save(cuenta);
            senderService.sendRestoreEmail(cuenta.getEmail());
        } catch(Exception e){
            logger.error(e);
            e.printStackTrace();
            throw new OperationErrorException(Constantes.RESTORE_PASSWORD_ERROR);
        }
        

    }

    public void restoreAccount(RestoreAccountDto request){
        if(!cuentaService.existsByEmail(request.getEmail())){
            throw new NotFoundException(Constantes.ACCOUNT_NOT_FOUND);
        }
        try{
            Cuenta cuenta = cuentaService.getByEmail(request.getEmail()).get();
            String username = cuenta.getAlias();
            senderService.sendAccountEmail(cuenta.getEmail(), username);
        }catch(Exception exc){
            logger.error(exc);
            exc.printStackTrace();
            throw new OperationErrorException(Constantes.RESTORE_ACCOUNT_ERROR);
        }
    }
    

}
