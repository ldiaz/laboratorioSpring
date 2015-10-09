package com.laboratorioprueba.laboratorio1.spring_mvc.controladores;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.stereotype.Controller;

@Controller
public class ControladorEstudiante {

	@RequestMapping(value="estudiante", method=RequestMethod.GET)
	public String formularioEstudiante(Model modelo){
		
		return "formularioEstudiante";
	}
	
}
