package com.curso.microservico.loja.service;

import com.curso.microservico.loja.model.dto.FornecedorInformacaoDto;
import com.curso.microservico.loja.model.form.CompraForm;
import com.curso.microservico.loja.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public ResponseEntity realizaCompra(CompraForm pCompra) {

        RestTemplate client = new RestTemplate();
        ResponseEntity<FornecedorInformacaoDto> exchange = client.exchange("http://localhost:8081/info/" + pCompra.getEndereco().getEstado(),
                HttpMethod.GET, null, FornecedorInformacaoDto.class);

        return null;
    }
}
