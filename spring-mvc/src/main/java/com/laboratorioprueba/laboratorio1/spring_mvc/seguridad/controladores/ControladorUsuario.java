package com.laboratorioprueba.laboratorio1.spring_mvc.seguridad.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.laboratorioprueba.laboratorio1.spring_mvc.seguridad.modelo.Usuario;
import com.laboratorioprueba.laboratorio1.spring_mvc.seguridad.service.InterfazServicioUsuario;

@Controller
public class ControladorUsuario {
	
	@Autowired
	private InterfazServicioUsuario servicioUsuario;

	@RequestMapping(value="/admin/usuarios/nuevo", method=RequestMethod.GET)
	public String formularioUsuario(Model modelo){
		
		Usuario u = new Usuario();
	
		
		modelo.addAttribute("usuario", u);
		
		return "seguridad/admin/formularioUsuario";
	}

	@RequestMapping(value="/admin/usuarios/crear", method=RequestMethod.POST)
	public String crearUsuario(@ModelAttribute Usuario datosUsuario, Model modelo){
		
		Usuario u = Usuario.createUsuario(datosUsuario.getUsername(), datosUsuario.getEmail(), datosUsuario.getPassword());
		
		servicioUsuario.guardarUsuario(u);
		
		modelo.addAttribute("usuario", u);
		
		return "seguridad/admin/detalleUsuario";
	}
}
