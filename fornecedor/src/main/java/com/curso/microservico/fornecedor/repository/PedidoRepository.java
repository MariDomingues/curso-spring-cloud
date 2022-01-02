package com.curso.microservico.fornecedor.repository;

import com.curso.microservico.fornecedor.model.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
