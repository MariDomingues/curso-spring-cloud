package com.curso.microservico.fornecedor.controller;

import com.curso.microservico.fornecedor.model.entity.ProdutoEntity;
import com.curso.microservico.fornecedor.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping("/{estado}")
	public List<ProdutoEntity> getProdutosPorEstado(@PathVariable("estado") String pEstado) {

		return produtoService.getProdutosPorEstado(pEstado);
	}
}
