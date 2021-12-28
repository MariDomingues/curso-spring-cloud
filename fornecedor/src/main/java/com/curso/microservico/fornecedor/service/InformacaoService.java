package com.curso.microservico.fornecedor.service;

import com.curso.microservico.fornecedor.model.dto.InformacaoDto;
import com.curso.microservico.fornecedor.model.entity.InformacaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InformacaoService {

    @Autowired
    private InformacaoRepository informacaoRepository;

    public ResponseEntity<InformacaoDto> getInformacao(String pEstado) {

        InformacaoEntity informacao = informacaoRepository.findByEstado(pEstado);

        return ResponseEntity.ok(new InformacaoDto(informacao));
    }
}
