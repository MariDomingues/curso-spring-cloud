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

    public ResponseEntity realizaCompra(CompraForm pCompra) throws Exception {

        String token = apiService.getToken(new URI("http://fornecedor/auth"), pCompra.getLogin());

        if (token != null) {
            apiService.enviarDados(token,"http://fornecedor/info/" + pCompra.getEndereco().getEstado(),
                    pCompra.getLogin(), new FornecedorInformacaoDto(""), HttpMethod.GET);
        }


        return null;
    }
}
