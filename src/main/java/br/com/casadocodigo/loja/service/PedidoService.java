package br.com.casadocodigo.loja.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.casadocodigo.loja.controllers.dto.PedidoDTO;
import br.com.casadocodigo.loja.controllers.dto.PedidoJsonDTO;

@Service
public class PedidoService {

	private static final String URL_PEDIDOS = "https://book-payment.herokuapp.com/orders";

	public List<PedidoDTO> findPedidos() {
		List<PedidoDTO> pedidoList = new ArrayList<>();

		RestTemplate template = new RestTemplate();

		try {
			ResponseEntity<String> responseEntity = template.exchange(URL_PEDIDOS, HttpMethod.GET, null, String.class);

			if (responseEntity.hasBody()) {
				preparePedido(responseEntity.getBody(), pedidoList);
			}
		} catch (RestClientException e) {
			System.out.println("Erro ao consumir serviço: " + URL_PEDIDOS);
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro genérico" + e.getMessage());
		}

		return pedidoList;
	}

	private void preparePedido(String body, List<PedidoDTO> dto) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		PedidoJsonDTO[] pedidos = mapper.readValue(body, PedidoJsonDTO[].class);

		for (PedidoJsonDTO pedido : pedidos) {
			PedidoDTO ped = new PedidoDTO();

			ped.setId(pedido.getId());
			ped.setValor(pedido.getValor());
			ped.setDataPedido(pedido.getData());
			String titulosWithSquareBrackets = pedido.getProdutos().stream().map(prod -> prod.getTitulo())
					.collect(Collectors.toList()).toString();
			ped.setTitulos(titulosWithSquareBrackets.substring(1, titulosWithSquareBrackets.length()-1));
			dto.add(ped);
		}
		;
	}

}
