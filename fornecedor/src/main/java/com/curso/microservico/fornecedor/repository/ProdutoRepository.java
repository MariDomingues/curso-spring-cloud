package com.curso.microservico.fornecedor.repository;

import com.curso.microservico.fornecedor.model.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

	List<ProdutoEntity> findByEstado(String estado);
	
	List<ProdutoEntity> findByIdIn(List<Long> ids);
}
