package br.com.casadocodigo.loja.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.casadocodigo.loja.controllers.dto.RelatorioProdutosDTO;
import br.com.casadocodigo.loja.service.RelatorioProdutoService;

@Controller
@RequestMapping(path = "/relatorio-produtos")
public class RelatorioProdutosController {

	@Autowired
	private RelatorioProdutoService relatorioProdutoService;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public RelatorioProdutosDTO findReport(@RequestParam(name = "data", required = false) String date)
			throws ParseException {
		Date dataLancamento = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		return relatorioProdutoService.prepareReport(dataLancamento);
	}
}
