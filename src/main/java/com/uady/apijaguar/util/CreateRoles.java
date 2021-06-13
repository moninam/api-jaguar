package com.uady.apijaguar.util;

import com.uady.apijaguar.enums.RolNombre;
import com.uady.apijaguar.model.Rol;
import com.uady.apijaguar.service.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner {
    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception{
        /*
        Rol rolAdmin = new Rol(RolNombre.ROL_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROL_USER);
        Rol rolMuseo = new Rol(RolNombre.ROL_MUSEO);

        rolService.save(rolAdmin);
        rolService.save(rolUser);
        rolService.save(rolMuseo);*/
    }
}
