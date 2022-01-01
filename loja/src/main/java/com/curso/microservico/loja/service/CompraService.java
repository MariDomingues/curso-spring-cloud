package com.curso.microservico.loja.service;

import com.curso.microservico.loja.model.dto.FornecedorInformacaoDto;
import com.curso.microservico.loja.model.form.CompraForm;
import com.curso.microservico.loja.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ApiService apiService;

    private final static String URL_PADRAO = "http://fornecedor/";

    public ResponseEntity<FornecedorInformacaoDto> realizaCompra(CompraForm pCompra) throws Exception {

        String token = apiService.getToken(pCompra.getLogin());
        FornecedorInformacaoDto fornecedorInformacao = new FornecedorInformacaoDto();

        if (token != null) {
            fornecedorInformacao = (FornecedorInformacaoDto) apiService.enviarDados(token, URL_PADRAO + "info/" + pCompra.getEndereco().getEstado(),
                    new FornecedorInformacaoDto(), HttpMethod.GET);
        }

        return ResponseEntity.ok(fornecedorInformacao);
    }
}