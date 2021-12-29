package com.curso.microservico.loja.controller;

import com.curso.microservico.loja.model.dto.LoginDto;
import com.curso.microservico.loja.model.entity.LoginEntity;
import com.curso.microservico.loja.model.form.LoginForm;
import com.curso.microservico.loja.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/{id}")
    public ResponseEntity<LoginDto> carregar(@PathVariable("id") Long pIdLogin) {

        return loginService.carregar(pIdLogin);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<LoginDto> insert(@RequestBody @Valid LoginForm pLogin,
                                            UriComponentsBuilder uriComponentsBuilder) {

        LoginEntity login = loginService.insert(pLogin);

        return ResponseEntity.created(uriComponentsBuilder
                .path("/login/{id}")
                .buildAndExpand(login.getId())
                .toUri()).body(new LoginDto(login));
    }
}
