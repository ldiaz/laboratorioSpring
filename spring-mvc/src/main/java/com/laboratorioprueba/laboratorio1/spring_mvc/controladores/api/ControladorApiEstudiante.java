package com.laboratorioprueba.laboratorio1.spring_mvc.controladores.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laboratorioprueba.laboratorio1.spring_mvc.domain.Estudiante;
import com.laboratorioprueba.laboratorio1.spring_mvc.servicios.ServicioEstudiante;

@Controller
public class ControladorApiEstudiante {

	@Autowired
	private ServicioEstudiante servEstudiante;
	
	
	@RequestMapping(value="api/estudiantes", method=RequestMethod.GET )
	public @ResponseBody List<Estudiante> listarEstudiantes(){
		
		return servEstudiante.listarEstudiantes(1, 5);
	}
	
}
