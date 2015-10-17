package com.laboratorioprueba.laboratorio1.spring_mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Aplicacion estudiantes Spring. Carlos Felipe Patiño 17/10/2015!
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
