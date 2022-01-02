package com.curso.microservico.fornecedor.controller;

import com.curso.microservico.fornecedor.model.dto.PedidoItemDto;
import com.curso.microservico.fornecedor.model.entity.PedidoEntity;
import com.curso.microservico.fornecedor.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<PedidoEntity> realizaPedido(@RequestBody List<PedidoItemDto> pListProduto) {

		return pedidoService.realizaPedido(pListProduto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoEntity> getPedidoPorId(@PathVariable("id") Long pIdPedido) {

		return pedidoService.getPedido(pIdPedido);
	}
}
