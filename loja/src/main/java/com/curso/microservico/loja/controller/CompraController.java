package com.curso.microservico.loja.controller;

import com.curso.microservico.loja.model.dto.CompraDto;
import com.curso.microservico.loja.model.form.CompraForm;
import com.curso.microservico.loja.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<CompraDto> realizaCompra(@RequestBody CompraForm pCompra) throws Exception {

        return compraService.realizaCompra(pCompra);
    }
}
