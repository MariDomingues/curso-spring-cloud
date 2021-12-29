package com.curso.microservico.fornecedor.service;

import com.curso.microservico.fornecedor.model.dto.FornecedorInformacaoDto;
import com.curso.microservico.fornecedor.model.entity.FornecedorInformacaoEntity;
import com.curso.microservico.fornecedor.repository.FornecedorInformacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FornecedorInformacaoService {

    @Autowired
    private FornecedorInformacaoRepository fornecedorInformacaoRepository;

    public ResponseEntity<FornecedorInformacaoDto> getInformacao(String pEstado) {

        FornecedorInformacaoEntity informacao = fornecedorInformacaoRepository.findByEstado(pEstado);

        return ResponseEntity.ok(new FornecedorInformacaoDto(informacao));
    }
}
