package com.laboratorioprueba.laboratorio1.spring_mvc.controladores;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.laboratorioprueba.laboratorio1.spring_mvc.domain.Estudiante;
import com.laboratorioprueba.laboratorio1.spring_mvc.repositorios.RepositorioEstudiante;
import com.laboratorioprueba.laboratorio1.spring_mvc.servicios.ServicioEstudiante;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ControladorEstudiante {
	
	@Autowired
	private ServicioEstudiante servEstudiante;

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
		
		servEstudiante.crearEstudiante(estudiante);

		return "vistaEstudiante";
	}
	
	@RequestMapping(value="estudiantes", method=RequestMethod.GET)
	public String listarEstudiantes(Model modelo){
		
		List<Estudiante> listado = servEstudiante.listarEstudiantes(1, 5);
		
		modelo.addAttribute("estudiantes", listado);
		
		
		return "listadoEstudiantes";
	}
	
	@RequestMapping(value="estudiantes/{idEstudiante}/editar", method=RequestMethod.GET)
	public String editarEstudiante(@PathVariable Integer idEstudiante, Model modelo){
		
		System.out.println("idEstudiante= "+ idEstudiante);
		
		Estudiante e = servEstudiante.buscarEstudiante(idEstudiante);
		
		modelo.addAttribute("estudiante", e);
		
		return "formularioEstudiante";
	}
	
	@RequestMapping(value="estudiantes/{idEstudiante}/eliminar", method=RequestMethod.GET)
	public String eliminarEstudiante(@PathVariable Integer idEstudiante, Model modelo){
		
		Estudiante e = null;
		try {
			e = servEstudiante.eliminarEstudiante(idEstudiante);
		} catch (Exception e1) {
			modelo.addAttribute("error", e1.getMessage());
		}
		
		modelo.addAttribute("estudiante", e);
		
		return "vistaEstudiante";
	}
	
}
