package com.uady.apijaguar.service;

import com.uady.apijaguar.model.Cuenta;
import com.uady.apijaguar.model.CuentaPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CuentaDetailsImpl implements UserDetailsService{

    @Autowired
    CuentaService cuentaService;

    @Override
    public UserDetails loadUserByUsername(String alias) throws UsernameNotFoundException {
        Cuenta cuenta = cuentaService.getByAlias(alias).get();
        
        return CuentaPrincipal.build(cuenta);
    }
    
}
