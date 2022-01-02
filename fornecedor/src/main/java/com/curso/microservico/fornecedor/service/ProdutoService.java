package com.curso.microservico.fornecedor.service;

import com.curso.microservico.fornecedor.model.entity.ProdutoEntity;
import com.curso.microservico.fornecedor.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<ProdutoEntity> getProdutosPorEstado(String estado) {

		return produtoRepository.findByEstado(estado);
	}
}
