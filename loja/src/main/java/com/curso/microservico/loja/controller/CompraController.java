package com.curso.microservico.loja.controller;

import com.curso.microservico.loja.model.dto.CompraDto;
import com.curso.microservico.loja.model.form.CompraForm;
import com.curso.microservico.loja.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity realizaCompra(@RequestBody CompraForm pCompra) throws Exception {

        return compraService.realizaCompra(pCompra);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getCompra(@PathVariable("idCompra") Long pIdCompra) throws Exception {

        return compraService.getCompra(pIdCompra);
    }
}
