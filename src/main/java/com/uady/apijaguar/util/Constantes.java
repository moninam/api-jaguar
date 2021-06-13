package com.uady.apijaguar.util;

public class Constantes {
    //MuseoRequest
    public static final String EMPTY_UB = "El campo de ubicación es obligatorio";
    public static final String EMPTY_NAME = "El campo de nombre es obligatorio";
    public static final String EMPTY_PHONE = "El campo de telefono es obligatorio";
    public static final String EMPTY_TARGET = "El campo de hasTarget es obligatorio";
    public static final String EMPTY_DESCRIPTION = "El campo de hasDescription es obligatorio";
    public static final String EMPTY_TYPE_COMPONENT = "El campo de Component Type es obligatorio";
    public static final String EMPTY_ACCOUNT = "El campo de cuenta es obligatorio";
    public static final String NOT_VALID_ACCOUNT = "El número de cuenta debe tener por lo menos un digito";
    //MuseoService
    public static final String ENTITY_NOT_FOUND = "La cuenta asociada no existe";

    //Auth
    public static final String ACCES_NOT_GRANTED = "No autorizado";
    public static final String HEADER = "Authorization";
    public static final String BEARER = "Bearer";
    public static final String ACCOUNT_NOT_FOUND = "La cuenta no esta registrada";
    public static final String DO_FILTER_ERROR = "Error en al obtener el token";
    public static final String ACCOUNT_ALREADY_EXIST = "El nombre de usuario ya esta registrado";
    public static final String EMAIL_ALREADY_EXIST = "El correo ya esa registrado en la cuenta";
    public static final String BAD_CREDENTIALS = "La contraseña o email es erroneo";
    public static final String OLD_PASS_WRONG = "La contraseña antigua no coincide";
    public static final String PASS_NOT_SAME = "Las contraseñas no coinciden";
    //Exceptions
    public static final String GENERAL_ERROR = "Ocurrio un error al realizar la operación,favor de intentarlo más tarde";
    public static final String ACCOUNT_ERROR = "Ocurrio un error al registrar la cuenta";
    public static final String LOGIN_ERROR = "Error al iniciar sesión, favor de intentarlo más tarde";
    public static final String NEW_TOKEN_ERROR = "Ocurrio un error al refrescar el token";
    public static final String RECOVER_PASSWORD_ERROR = "Ocurrio un error al recuperar la contraseña";
    public static final String RESTORE_PASSWORD_ERROR = "Ocurrio un error al cambiar la contraseña";
    public static final String RESTORE_ACCOUNT_ERROR = "Ocurrio un error al obtener la cuenta de usuario";
    
    //Email
    public static final String EMAIL_SEND = "Email enviado";
    public static final String EMAIL_ERROR ="Hubo un error al envíar el correo";
    public static final String EMAIL_RECOVER_SUBJECT = "Recuperación de contraseña";
    public static final String EMAIL_REGISTER_SUBJECT = "Registro de cuenta";
    public static final String EMAIL_ACCOUNT_RESTORE = "Recuperación de cuenta";
    public static final String EMAIL_RESTORE_SUBJECT = "Cambio de contraseña";


}
