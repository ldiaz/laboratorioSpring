package com.laboratorioprueba.laboratorio1.spring_mvc.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.laboratorioprueba.laboratorio1.spring_mvc.domain.Estudiante;


public interface RepositorioEstudiante extends CrudRepository<Estudiante, Integer>{
	
	//buscar estudiantes menores de cierta edad
	public List<Estudiante> findByFechaNacimientoAfter(Date fechaConsulta);

}
