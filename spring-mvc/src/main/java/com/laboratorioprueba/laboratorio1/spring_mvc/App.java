package com.laboratorioprueba.laboratorio1.spring_mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Edito la misma linea aproposito
 * voy a darle commit en mi repositorio local y luego trato de subir cambios a
 * repositorio remoto
 *
 */
@SpringBootApplication
public class App 
{
	private static final Logger log = LoggerFactory.getLogger(App.class);

	
    public static void main( String[] args )
    {
        log.debug("Iniciando la aplicacion de spring");
		SpringApplication.run(App.class);

    }
}
