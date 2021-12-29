package com.curso.microservico.loja.repository;

import com.curso.microservico.loja.model.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginEntity, Long> {
}
