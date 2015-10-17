package com.laboratorioprueba.laboratorio1.spring_mvc.seguridad.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordCrypto {

    private PasswordEncoder passwordEncoder;
    
    private static PasswordCrypto instance;
    
    private PasswordCrypto(){
    	passwordEncoder = new BCryptPasswordEncoder();
    }


    public static PasswordCrypto getInstance() {
        if(instance == null) {
            instance = new PasswordCrypto();
        }

        return instance;
    }

    public String encrypt(String str) {
        return passwordEncoder.encode(str);
    }
}