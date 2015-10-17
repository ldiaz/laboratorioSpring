package com.laboratorioprueba.laboratorio1.spring_mvc.seguridad.repositorio;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laboratorioprueba.laboratorio1.spring_mvc.seguridad.modelo.Usuario;

@Repository
@Qualifier(value = "userRepository")
public interface RepositorioUsuario extends CrudRepository<Usuario, Long> {
    public Usuario findByUsername(String username);
    
   
}