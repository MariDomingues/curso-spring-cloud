package com.curso.microservico.loja.client;

import com.curso.microservico.loja.model.dto.FornecedorInformacaoDto;
import com.curso.microservico.loja.model.dto.TokenDto;
import com.curso.microservico.loja.model.form.LoginForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@FeignClient(name = "fornecedor")
public interface FornecedorClient {

    @RequestMapping(method = RequestMethod.POST, value = "auth")
    ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm pLogin);

    @RequestMapping(method = RequestMethod.GET, value = "info/{estado}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<FornecedorInformacaoDto> getInformacao(@PathVariable("estado") String pEstado, @RequestHeader("Authorization") String header);
}
