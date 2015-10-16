package com.laboratorioprueba.laboratorio1.spring_mvc.seguridad.modelo;
import javax.persistence.*;

import com.laboratorioprueba.laboratorio1.spring_mvc.seguridad.utils.PasswordCrypto;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "usuario")
    private Set<RolUsuario> roles;

    public static Usuario createUsuario(String username, String email, String password) {
        Usuario Usuario = new Usuario();

        Usuario.username = username;
        Usuario.email = email;
        Usuario.password = PasswordCrypto.getInstance().encrypt(password);

        if(Usuario.roles == null) {
            Usuario.roles = new HashSet<RolUsuario>();
        }

        //crea un usuario nuevo con privilegio basicos de usuario
        Usuario.roles.add(
                new RolUsuario(
                        RolEnum.USER.toString(),
                        Usuario
                ));

        return Usuario;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<RolUsuario> getRoles() {
		return roles;
	}

	public void setRoles(Set<RolUsuario> roles) {
		this.roles = roles;
	}

}