package br.com.casadocodigo.loja.controllers.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PedidoDTO implements Serializable {

	private static final long serialVersionUID = -2044803065134194524L;

	private Integer id;

	private BigDecimal valor;

	private Date dataPedido;

	private String titulos = "";

	public Integer getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public String getTitulos() {
		return titulos;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public void setTitulos(String titulos) {
		this.titulos = titulos;
	}

}
