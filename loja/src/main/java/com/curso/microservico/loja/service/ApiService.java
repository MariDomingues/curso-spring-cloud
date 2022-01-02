package com.curso.microservico.loja.service;

import com.curso.microservico.loja.client.FornecedorClient;
import com.curso.microservico.loja.model.dto.fornecedor.FornecedorDto;
import com.curso.microservico.loja.model.dto.fornecedor.PedidoDto;
import com.curso.microservico.loja.model.form.CompraItemDto;
import com.curso.microservico.loja.model.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiService {

    @Autowired
    private FornecedorClient fornecedorClient;

    public FornecedorDto getEnderecoFornecedor(LoginForm pLogin, String pEstado) {

        try {
            return fornecedorClient.getInformacao(pEstado, getHeader(pLogin)).getBody();

        } catch (Exception ex) {
            return null;
        }
    }

    public PedidoDto setPedido(LoginForm pLogin, List<CompraItemDto> pListItem) {

        return fornecedorClient.realizaPedido(pListItem, getHeader(pLogin)).getBody();
    }

    private String getHeader(LoginForm pLogin) {

        return "Bearer " + fornecedorClient.autenticar(pLogin).getBody().getToken();
    }
}
