package br.com.casadocodigo.loja.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.casadocodigo.loja.controllers.dto.PrecoDTO;
import br.com.casadocodigo.loja.controllers.dto.ProdutoDTO;
import br.com.casadocodigo.loja.controllers.dto.RelatorioProdutosDTO;
import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Preco;
import br.com.casadocodigo.loja.models.Produto;

@Service
public class RelatorioProdutoService {

	@Autowired
	private ProdutoDAO produtoDAO;

	public RelatorioProdutosDTO prepareReport(Date dataLancamento) {

		List<Produto> prepareReport = produtoDAO.prepareReport(dataLancamento);

		return prepareReportDTO(prepareReport);
	}

	private RelatorioProdutosDTO prepareReportDTO(List<Produto> prepareReport) {
		RelatorioProdutosDTO dto = new RelatorioProdutosDTO();

		if (prepareReport == null || prepareReport.isEmpty())
			return dto;

		dto.setDataGeracao(new Date());

		prepareReport.forEach(prod -> {
			ProdutoDTO dtoProd = new ProdutoDTO();
			dtoProd.setId(prod.getId());
			dtoProd.setDataLancamento(prod.getDataLancamento().getTime());
			dtoProd.setDescricao(prod.getDescricao());
			dtoProd.setPaginas(prod.getPaginas());
			dtoProd.setSumarioPath(prod.getSumarioPath());
			dtoProd.setTitulo(prod.getTitulo());
			dtoProd.setPrecos(preparePriceProducts(prod.getPrecos()));
			dto.getProdutos().add(dtoProd);
		});

		return dto;
	}

	private List<PrecoDTO> preparePriceProducts(List<Preco> precos) {
		List<PrecoDTO> dtoPrice = new ArrayList<>();

		if (precos == null || precos.isEmpty())
			return dtoPrice;

		precos.forEach(pre -> {
			PrecoDTO dto = new PrecoDTO();
			dto.setTipo(pre.getTipo().name());
			dto.setValor(new DecimalFormat("#.##").format(pre.getValor()));
			dtoPrice.add(dto);
		});
		return dtoPrice;
	}

}
