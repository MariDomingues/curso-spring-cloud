package com.curso.microservico.fornecedor.controller;

import com.curso.microservico.fornecedor.model.dto.InformacaoDto;
import com.curso.microservico.fornecedor.service.InformacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("info")
public class InformacaoController {

    @Autowired
    private InformacaoService informacaoService;

    @GetMapping("/{estado}")
    public ResponseEntity<InformacaoDto> getInformacao(@PathVariable("estado") String pEstado) {

        return informacaoService.getInformacao(pEstado);
    }
}
