package com.curso.microservico.fornecedor.service;

import com.curso.microservico.fornecedor.model.entity.InformacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformacaoRepository extends JpaRepository<InformacaoEntity, Long> {

    InformacaoEntity findByEstado(String pEstado);
}
