package com.curso.microservico.fornecedor.controller;

import com.curso.microservico.fornecedor.model.dto.PedidoItemDto;
import com.curso.microservico.fornecedor.model.entity.PedidoEntity;
import com.curso.microservico.fornecedor.service.PedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {

	private static final Logger log = LoggerFactory.getLogger(PedidoController.class);

	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<PedidoEntity> realizaPedido(@RequestBody List<PedidoItemDto> pListProduto) {

		log.info("Pedido de Compra recebido!");
		return pedidoService.realizaPedido(pListProduto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoEntity> getPedido(@PathVariable("id") Long pIdPedido) {

		return pedidoService.getPedido(pIdPedido);
	}
}
