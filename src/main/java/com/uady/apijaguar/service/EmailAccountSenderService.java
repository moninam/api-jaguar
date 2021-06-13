package com.uady.apijaguar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uady.apijaguar.dto.EmailDto;
import com.uady.apijaguar.util.Constantes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class EmailAccountSenderService {
    private Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private EmailService emailService;

    public void sendRecoverEmail(String password, String email){
        String subject = Constantes.EMAIL_RECOVER_SUBJECT;
        String content = "Se ha solicitado la recuperación de contraseña." + "\n"
                        + "Nueva Contraseña: " + password + "\n"
                        + "Favor de cambiarla lo antes posible";
        EmailDto emailBody = new EmailDto(email,content,subject);

        emailService.sendEmail(emailBody);
    }

    public void sendRegisterEmail(String email,String username){
        String subject = Constantes.EMAIL_REGISTER_SUBJECT;
        String content = "Se ha creado su cuenta con éxito" + "\n"
                        + "Favor de ingresar con el siguiente usuario: " + username;
        EmailDto emailBody = new EmailDto(email,content,subject);

        emailService.sendEmail(emailBody);
    }

    public void sendRestoreEmail(String email){
        String subject = Constantes.EMAIL_RESTORE_SUBJECT;
        String content = "Se ha cambiado con éxito su contraseña" + "\n"
                        + "Favor de ingresar con sus credenciales";
        EmailDto emailBody = new EmailDto(email,content,subject);

        emailService.sendEmail(emailBody);
    }

    public void sendAccountEmail(String email, String account){
        String subject = Constantes.EMAIL_ACCOUNT_RESTORE;
        String content = "Se ha solicitado la recuperación de la cuenta" + "\n"
                        + "Cuenta: " + account + "\n";
        EmailDto emailBody = new EmailDto(email,content,subject);
        emailService.sendEmail(emailBody);
    }
}
