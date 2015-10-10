package com.laboratorioprueba.laboratorio1.spring_mvc.controladores;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.laboratorioprueba.laboratorio1.spring_mvc.domain.Estudiante;
import com.laboratorioprueba.laboratorio1.spring_mvc.repositorios.RepositorioEstudiante;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ControladorEstudiante {
	
	@Autowired
	private RepositorioEstudiante repoEstudiante;

	@RequestMapping(value="estudiantes/nuevo", method=RequestMethod.GET)
	public String formularioEstudiante(Model modelo){
		
		System.out.println("Obteniendo el formulario");
		modelo.addAttribute("estudiante", new Estudiante());
		
		return "formularioEstudiante";
	}
	
	@RequestMapping(value="estudiantes/crear", method=RequestMethod.POST)
	public String crearEstudiante(@ModelAttribute Estudiante estudiante, Model modelo){
		
		System.out.println("posteando desde el formulario");
		estudiante.setNombre(estudiante.getNombre());
		
		repoEstudiante.save(estudiante);

		return "vistaEstudiante";
	}
	
	@RequestMapping(value="estudiantes", method=RequestMethod.GET)
	public String listarEstudiantes(Model modelo){
		
		List<Estudiante> listado = (List<Estudiante>) repoEstudiante.findAll();
		
		modelo.addAttribute("estudiantes", listado);
		
		
		return "listadoEstudiantes";
	}
	
	@RequestMapping(value="estudiantes/{idEstudiante}/editar", method=RequestMethod.GET)
	public String editarEstudiante(@PathVariable Integer idEstudiante, Model modelo){
		
		System.out.println("idEstudiante= "+ idEstudiante);
		
		Estudiante e = repoEstudiante.findOne(idEstudiante);
		
		modelo.addAttribute("estudiante", e);
		
		return "formularioEstudiante";
	}
	
}
