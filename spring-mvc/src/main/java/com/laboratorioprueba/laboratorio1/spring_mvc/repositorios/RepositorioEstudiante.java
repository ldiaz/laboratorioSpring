package com.laboratorioprueba.laboratorio1.spring_mvc.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.laboratorioprueba.laboratorio1.spring_mvc.domain.Estudiante;


public interface RepositorioEstudiante extends CrudRepository<Estudiante, Integer>{

}
