package br.com.casadocodigo.loja.controllers.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UsuarioSimplesDTO implements Serializable {

	private static final long serialVersionUID = 1062591275225124234L;
	private String nome;
	private String email;
	private List<Role> regras = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRegras() {
		return regras;
	}
	
	public String getStringRegras() {
		return regras.toString();
	}
	
	public void setRegras(List<Role> regras) {
		this.regras = regras;
	}

}
