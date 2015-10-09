package com.laboratorioprueba.laboratorio1.spring_mvc.controladores;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.laboratorioprueba.laboratorio1.spring_mvc.domain.Estudiante;


import org.springframework.stereotype.Controller;

@Controller
public class ControladorEstudiante {

	@RequestMapping(value="estudiante", method=RequestMethod.GET)
	public String formularioEstudiante(Model modelo){
		
		System.out.println("Obteniendo el formulario");
		modelo.addAttribute("estudiante", new Estudiante());
		
		return "formularioEstudiante";
	}
	
	@RequestMapping(value="estudiante", method=RequestMethod.POST)
	public String crearEstudiante(@ModelAttribute Estudiante estudiante, Model modelo){
		
		System.out.println("posteando desde el formulario");

		return "formularioEstudiante";
	}
}
