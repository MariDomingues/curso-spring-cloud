package com.curso.microservico.loja.service;

import com.curso.microservico.loja.client.FornecedorClient;
import com.curso.microservico.loja.model.dto.fornecedor.FornecedorDto;
import com.curso.microservico.loja.model.dto.fornecedor.PedidoDto;
import com.curso.microservico.loja.model.dto.fornecedor.TokenDto;
import com.curso.microservico.loja.model.form.CompraItemDto;
import com.curso.microservico.loja.model.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public PedidoDto setPedido(LoginForm pLogin, List<CompraItemDto> pListItem) throws Exception {

        ResponseEntity<PedidoDto> pedido = fornecedorClient.realizaPedido(pListItem, getHeader(pLogin));

        if (pedido != null) {
            return pedido.getBody();
        }

        throw new Exception("Pedido não Gerado!");
    }

    private String getHeader(LoginForm pLogin) throws Exception {

        ResponseEntity<TokenDto> autenticar = fornecedorClient.autenticar(pLogin);

        if (autenticar != null) {
            return "Bearer " + autenticar.getBody().getToken();
        }

        throw new Exception("Token não Gerado!");
    }
}
