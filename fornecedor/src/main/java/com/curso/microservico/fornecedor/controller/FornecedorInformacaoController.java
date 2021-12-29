package com.curso.microservico.fornecedor.controller;

import com.curso.microservico.fornecedor.model.dto.FornecedorInformacaoDto;
import com.curso.microservico.fornecedor.service.FornecedorInformacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("info")
public class FornecedorInformacaoController {

    @Autowired
    private FornecedorInformacaoService fornecedorInformacaoService;

    @GetMapping("/{estado}")
    public ResponseEntity<FornecedorInformacaoDto> getInformacao(@PathVariable("estado") String pEstado) {

        return fornecedorInformacaoService.getInformacao(pEstado);
    }
}
