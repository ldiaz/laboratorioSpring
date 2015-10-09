package com.laboratorioprueba.laboratorio1.spring_mvc.domain;

public class Estudiante {

	private String nombre;
	private String apellido;
	private int numeroIdentificacion;
	private String tipoDocumentoIdentificacion;
	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(int numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	public String getTipoDocumentoIdentificacion() {
		return tipoDocumentoIdentificacion;
	}
	public void setTipoDocumentoIdentificacion(String tipoDocumentoIdentificacion) {
		this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
	}
	
	
	
	
}
