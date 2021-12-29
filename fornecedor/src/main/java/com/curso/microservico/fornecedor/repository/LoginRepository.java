package com.curso.microservico.fornecedor.repository;

import com.curso.microservico.fornecedor.model.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Long> {

    Optional<LoginEntity> findByUsuario(String pUsername);
}
