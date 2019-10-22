package br.com.casadocodigo.loja.controllers.dto;

import java.io.Serializable;

public class Role implements Serializable{

	private static final long serialVersionUID = -4336257112390912178L;
	private String regra;
	
	public Role(){
	}
	
	public Role(String role) {
		this.regra = role;
	}

	public String getRegra() {
		return regra;
	}

	public void setRegra(String regra) {
		this.regra = regra;
	}

	@Override
	public String toString() {
		return regra;
	}
	
	
}
