package br.com.casadocodigo.loja.controllers.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = 2371066712903791220L;

	private Integer id;

	private String titulo;
	private String descricao;
	private int paginas;

	private String sumarioPath;

	private List<PrecoDTO> precos = new ArrayList<>();

	@DateTimeFormat
	private Date dataLancamento;

	public Integer getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getPaginas() {
		return paginas;
	}

	public String getSumarioPath() {
		return sumarioPath;
	}

	public List<PrecoDTO> getPrecos() {
		return precos;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public void setSumarioPath(String sumarioPath) {
		this.sumarioPath = sumarioPath;
	}

	public void setPrecos(List<PrecoDTO> precos) {
		this.precos = precos;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	
}
