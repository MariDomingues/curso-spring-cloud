package com.curso.microservico.fornecedor.repository;

import com.curso.microservico.fornecedor.model.entity.FornecedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<FornecedorEntity, Long> {

    FornecedorEntity findByEstado(String pEstado);
}
