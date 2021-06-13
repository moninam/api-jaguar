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
    
    //Exceptions
    public static final String GENERAL_ERROR = "Ocurrio un error al realizar la operación,favor de intentarlo más tarde";
    public static final String ACCOUNT_ERROR = "Ocurrio un error al registrar la cuenta";
    public static final String LOGIN_ERROR = "Error al iniciar sesión, favor de intentarlo más tarde";
    public static final String NEW_TOKEN_ERROR = "Ocurrio un error al refrescar el token";

}
