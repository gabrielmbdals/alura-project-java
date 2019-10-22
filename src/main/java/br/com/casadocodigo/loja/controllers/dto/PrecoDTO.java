package br.com.casadocodigo.loja.controllers.dto;

import java.io.Serializable;

public class PrecoDTO implements Serializable {

	private static final long serialVersionUID = 2406605854033300838L;

	private String valor;

	private String tipo;

	public String getValor() {
		return valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
