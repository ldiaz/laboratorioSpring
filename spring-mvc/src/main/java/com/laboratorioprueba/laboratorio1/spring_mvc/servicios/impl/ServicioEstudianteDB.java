package com.laboratorioprueba.laboratorio1.spring_mvc.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratorioprueba.laboratorio1.spring_mvc.domain.Estudiante;
import com.laboratorioprueba.laboratorio1.spring_mvc.repositorios.RepositorioEstudiante;
import com.laboratorioprueba.laboratorio1.spring_mvc.servicios.ServicioEstudiante;

@Service
public class ServicioEstudianteDB implements ServicioEstudiante{
	
	@Autowired
	private RepositorioEstudiante repoEstudiante;

	@Override
	public Estudiante buscarEstudiante(int idEstudiante) {
		
		return repoEstudiante.findOne(idEstudiante);
	}

	@Override
	public Estudiante crearEstudiante(Estudiante nuevoEstudiante) {
		
		return repoEstudiante.save(nuevoEstudiante);
	}

	@Override
	public Estudiante actualizarEstudiante(int idEstudiante, Estudiante estudiante) throws Exception {
		Estudiante e = repoEstudiante.findOne(idEstudiante);
		
		if (e != null) {
			
			if(idEstudiante != estudiante.getNumeroIdentificacion()){
				Estudiante nuevo = this.buscarEstudiante(estudiante.getNumeroIdentificacion());
				if(nuevo != null){
					
					throw new Exception("Estudiante "+estudiante.getNumeroIdentificacion()+" ya existe en el sistema, no se puede atualizar con dicho numero de identificacion");
				}
				
				e.setNumeroIdentificacion(estudiante.getNumeroIdentificacion());
			}

			e.setNombre(estudiante.getNombre());
			e.setApellido(estudiante.getApellido());
			e.setTipoDocumentoIdentificacion(estudiante.getTipoDocumentoIdentificacion());
			
			repoEstudiante.save(e);
		}else{
			
			throw new Exception("Estudiante "+idEstudiante+" no se encuentra en el sistema");
		}	
		
		return e;
	}

	@Override
	public List<Estudiante> listarEstudiantes(int pagina, int cantidadResultados) {
		
		return (List<Estudiante>) repoEstudiante.findAll();
	}

	@Override
	public Estudiante eliminarEstudiante(int idEstudiante) throws Exception {
		Estudiante e = repoEstudiante.findOne(idEstudiante);
		
		if (e != null) {
			repoEstudiante.delete(e);
		}else{
			
			throw new Exception("Estudiante "+idEstudiante+" no se encuentra en el sistema");
		}	
		
		return e;
	}
}