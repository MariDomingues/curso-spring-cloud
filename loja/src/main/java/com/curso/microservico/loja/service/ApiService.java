package com.curso.microservico.loja.service;

import com.curso.microservico.loja.client.FornecedorClient;
import com.curso.microservico.loja.interfaces.GenericResponse;
import com.curso.microservico.loja.model.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

    @Autowired
    private FornecedorClient fornecedorClient;

    public GenericResponse enviarDados(LoginForm pLogin, String pEstado) {

        try {
            return fornecedorClient.getInformacao(pEstado, "Bearer " + fornecedorClient.autenticar(pLogin).getBody().getToken()).getBody();

        } catch (Exception ex) {
            return null;
        }
    }
}
