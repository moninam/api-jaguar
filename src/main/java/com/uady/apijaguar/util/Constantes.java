package com.uady.apijaguar.util;

public class Constantes {
    //MuseoRequest
    public static final String EMPTY_UB = "El campo de ubicación es obligatorio";
    public static final String EMPTY_LAT = "El campo de latitud es obligatorio";
    public static final String EMPTY_LONG = "El campo de longitud es obligatorio";
    public static final String EMPTY_NAME = "El campo de nombre es obligatorio";
    public static final String EMPTY_PHONE = "El campo de telefono es obligatorio";
    public static final String EMPTY_TARGET = "El campo de hasTarget es obligatorio";
    public static final String EMPTY_DESCRIPTION = "El campo de hasDescription es obligatorio";
    public static final String EMPTY_TYPE_COMPONENT = "El campo de Component Type es obligatorio";
    public static final String EMPTY_ACCOUNT = "El campo de cuenta es obligatorio";
    public static final String NOT_VALID_ACCOUNT = "El número de cuenta debe tener por lo menos un digito";
    public static final String EMPTY_URL_IMAGEN = "El url de imagen no puede ser vacio";
    public static final String EMPTY_ALIAS = "El alias no puede estar vacio";
    public static final String EMPTY_EMAIL = "El email no puede estar vacio";
    public static final String EMPTY_PASSWORD = "La contraseña no puede estar vacia";
    public static final String EMPTY_DIRECTION = "La direccion no puede estar vacia";
    public static final String EMPTY_TELEFONO = "El telefono no puede estar vacio";
    public static final String EMPTY_LATITUD = "El formato de la latitud es erronea";
    public static final String EMPTY_LONGITUD = "El formato de la longitud es erroneo";
    public static final String EMPTY_NOMBRE = "El nombre no puede estar vacio";
    public static final String EMAIL_ERROR_FORMAT = "El formato de email es erroneo";
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
    public static final String MUSEO_R_ERROR = "Ocurrio un error al registrar el museo";
    public static final String LOGIN_ERROR = "Error al iniciar sesión, favor de intentarlo más tarde";
    public static final String NEW_TOKEN_ERROR = "Ocurrio un error al refrescar el token";
    public static final String RECOVER_PASSWORD_ERROR = "Ocurrio un error al recuperar la contraseña";
    public static final String RESTORE_PASSWORD_ERROR = "Ocurrio un error al cambiar la contraseña";
    public static final String RESTORE_ACCOUNT_ERROR = "Ocurrio un error al obtener la cuenta de usuario";
    public static final String MUSEO_NOT_FOUND = "No se encontro algún museo cerca de tu localidad";
    public static final String MUSEO_NOT_EXIST = "El museo no se encuentra registrado en el sistema";
    public static final String GRUPO_NOT_EXIST = "El grupo no se encuentra registrado en el sistema";
    public static final String GRUPO_ERROR_R = "Ocurrio un error al registrar al grupo";
    public static final String GRUPO_DELETE_ERROR = "Ocurrio un error al eliminarl el grupo";
    
    //Email
    public static final String EMAIL_SEND = "Email enviado";
    public static final String EMAIL_ERROR ="Hubo un error al envíar el correo";
    public static final String EMAIL_RECOVER_SUBJECT = "Recuperación de contraseña";
    public static final String EMAIL_REGISTER_SUBJECT = "Registro de cuenta";
    public static final String EMAIL_ACCOUNT_RESTORE = "Recuperación de cuenta";
    public static final String EMAIL_RESTORE_SUBJECT = "Cambio de contraseña";

    //MODULO ADMIN
    //GRUPOS
    public static final String NOMBRE_EMPTY = "El nombre no puede ser vacio";
    public static final String DESCRIPCION_EMPTY = "La descripción no puede ser vacia";
    public static final String URL_IMAGEN_EMPTY = "La url de la imagen no puede ser vacia";
    public static final String MUSEO_NOT_VALID = "El id del museo es erroneo";
    public static final String MUSEO_EMPTY = "El id del museo no puede estar vacio";
    public static final String GRUPO_DELETE = "El grupo se ha eliminado con éxito";



}
