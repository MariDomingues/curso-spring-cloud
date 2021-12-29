package com.curso.microservico.fornecedor.controller;

import com.curso.microservico.fornecedor.model.dto.TokenDto;
import com.curso.microservico.fornecedor.model.form.LoginForm;
import com.curso.microservico.fornecedor.service.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("auth")
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping
    public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm pLogin) {

        return autenticacaoService.autenticar(pLogin);
    }
}