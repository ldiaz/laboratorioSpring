package com.laboratorioprueba.laboratorio1.spring_mvc.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.laboratorioprueba.laboratorio1.spring_mvc.domain.Estudiante;

public interface ServicioEstudiante {
	
	public Estudiante buscarEstudiante(int idEstudiante);
	
	public Estudiante crearEstudiante(Estudiante nuevoEstudiante);
	
	public Estudiante actualizarEstudiante(int idEstudiante, Estudiante estudiante) throws Exception;
	
	public List<Estudiante> listarEstudiantes(int pagina, int cantidadResultados);
	
	public Estudiante eliminarEstudiante(int idEstudiante) throws Exception;
	
}
