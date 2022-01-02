package com.curso.microservico.loja.service;

import com.curso.microservico.loja.client.FornecedorClient;
import com.curso.microservico.loja.client.PedidoClient;
import com.curso.microservico.loja.model.dto.FornecedorDto;
import com.curso.microservico.loja.model.dto.PedidoInfoDto;
import com.curso.microservico.loja.model.form.CompraItemForm;
import com.curso.microservico.loja.model.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiService {

    @Autowired
    private FornecedorClient fornecedorClient;

    @Autowired
    private PedidoClient pedidoClient;

    public FornecedorDto getEnderecoFornecedor(LoginForm pLogin, String pEstado) {

        try {
            return fornecedorClient.getInformacao(pEstado, getHeader(pLogin)).getBody();

        } catch (Exception ex) {
            return null;
        }
    }

    public PedidoInfoDto setPedido(LoginForm pLogin, List<CompraItemForm> pListItem) {

        try {
            return pedidoClient.realizaPedido(pListItem, getHeader(pLogin));

        } catch (Exception ex) {
            return null;
        }
    }

    private String getHeader(LoginForm pLogin) {

        return "Bearer " + fornecedorClient.autenticar(pLogin).getBody().getToken();
    }
}
