package com.laboratorioprueba.laboratorio1.spring_mvc.seguridad.modelo;
import javax.persistence.*;

@Entity
@Table(name = "rol_usuario")
public class RolUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @Column(name = "nombre_rol")
    private String nombreRol;

    @ManyToOne
    private Usuario usuario;

    public RolUsuario() {
    }

    public RolUsuario(String nombreRol, Usuario usuario) {
        this.nombreRol = nombreRol;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}