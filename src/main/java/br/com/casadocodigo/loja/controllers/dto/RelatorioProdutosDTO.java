package br.com.casadocodigo.loja.controllers.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class RelatorioProdutosDTO implements Serializable {

	private static final long serialVersionUID = 8342692709307415571L;

	@DateTimeFormat
	private Date dataGeracao;

	private int quantidade = 0;

	private List<ProdutoDTO> produtos = new ArrayList<>();

	public int getQuantidade() {
		this.quantidade = this.produtos.size();
		return this.quantidade;
	}

	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}

	public Date getDataGeracao() {
		return dataGeracao;
	}

	public void setDataGeracao(Date dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

}
