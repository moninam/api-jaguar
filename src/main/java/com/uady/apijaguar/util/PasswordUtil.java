package com.uady.apijaguar.util;

import com.mifmif.common.regex.Generex;

public class PasswordUtil {
    public static final String passRegex = "([a-zA-Z]){3}([0-9]){4}([a-zA-Z]){1}";

    public static String generatePassword(){
        Generex generex = new Generex(passRegex);
        String password = generex.random();

        return password;
    }
}
