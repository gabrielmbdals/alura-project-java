package br.com.casadocodigo.loja.controllers.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PedidoJsonDTO {
	
	private Integer id;
	private BigDecimal valor;
	private Date data;
	private List<ProdutoDTO> produtos;
	
	public Integer getId() {
		return id;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public Date getData() {
		return data;
	}
	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public void setProdutos(List<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}
	
}
