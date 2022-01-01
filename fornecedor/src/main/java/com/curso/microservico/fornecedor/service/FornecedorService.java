package com.curso.microservico.fornecedor.service;

import com.curso.microservico.fornecedor.model.dto.FornecedorDto;
import com.curso.microservico.fornecedor.model.entity.FornecedorEntity;
import com.curso.microservico.fornecedor.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public ResponseEntity<FornecedorDto> getInformacao(String pEstado) {

        FornecedorEntity informacao = fornecedorRepository.findByEstado(pEstado);

        return ResponseEntity.ok(new FornecedorDto(informacao));
    }
}
