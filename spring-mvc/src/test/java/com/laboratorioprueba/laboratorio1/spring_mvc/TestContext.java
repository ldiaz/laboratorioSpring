package com.laboratorioprueba.laboratorio1.spring_mvc;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.laboratorioprueba.laboratorio1.spring_mvc.servicios.ServicioEstudiante;
 
//Configuration
public class TestContext {
 
//    @Bean
//    public MessageSource messageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
// 
//        messageSource.setBasename("i18n/messages");
//        messageSource.setUseCodeAsDefaultMessage(true);
// 
//        return messageSource;
//    }
 
    @Bean
    @Qualifier("estudianteServiceMock")
    public ServicioEstudiante estudianteServiceMock() {
        return Mockito.mock(ServicioEstudiante.class);
    }
}