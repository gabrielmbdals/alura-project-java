package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.controllers.dto.PedidoDTO;
import br.com.casadocodigo.loja.service.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidosServicoController {

	@Autowired
	private PedidoService pedidoService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView pedido() {
		ModelAndView modelAndView = new ModelAndView("pedido");
		List<PedidoDTO> pedidoDTO = pedidoService.findPedidos();
		modelAndView.addObject("pedidos", pedidoDTO);
		return modelAndView;
	}
}
