package com.curso.microservico.fornecedor.repository;

import com.curso.microservico.fornecedor.model.entity.FornecedorInformacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorInformacaoRepository extends JpaRepository<FornecedorInformacaoEntity, Long> {

    FornecedorInformacaoEntity findByEstado(String pEstado);
}
