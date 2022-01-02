package com.curso.microservico.fornecedor.controller;

import com.curso.microservico.fornecedor.model.dto.FornecedorDto;
import com.curso.microservico.fornecedor.service.FornecedorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("info")
public class FornecedorController {

    private static final Logger log = LoggerFactory.getLogger(FornecedorController.class);

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/{estado}")
    public ResponseEntity<FornecedorDto> getInformacao(@PathVariable("estado") String pEstado) {

        log.info("Carregando informações do Foencedor de {}", pEstado);
        return fornecedorService.getInformacao(pEstado);
    }
}
