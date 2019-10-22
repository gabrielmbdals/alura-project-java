package br.com.casadocodigo.loja.controllers.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1062591275225124234L;
	private String nome;
	private String email;
	private String password;
	private String repassword;
	private List<Role> roles = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public String getStringRoles() {
		return roles.toString();
	}

	public void setRoles(List<Role> regras) {
		this.roles = regras;
	}

}
