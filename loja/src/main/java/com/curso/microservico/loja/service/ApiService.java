package com.curso.microservico.loja.service;

import com.curso.microservico.loja.client.FornecedorClient;
import com.curso.microservico.loja.interfaces.GenericResponse;
import com.curso.microservico.loja.model.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class ApiService {

    private RequestEntity request;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FornecedorClient fornecedorClient;

    public GenericResponse enviarDados(String pToken, String pUrl, GenericResponse pDadosResposta, HttpMethod pTipoTransacao) throws Exception {

        ResponseEntity<GenericResponse> retorno = postHttps(pToken, new URI(pUrl), pDadosResposta.getClass(), pTipoTransacao);

        if (retorno != null && (retorno.getStatusCode() == HttpStatus.OK || retorno.getStatusCode() == HttpStatus.ALREADY_REPORTED)) {
            return retorno.getBody();

        } else {
            return null;
        }
    }

    protected ResponseEntity postHttps(String pToken, URI pUrl, Class<?> pClasse, HttpMethod pTipoTransacao) {

        try {
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE.toString());
            headers.add("Authorization", "Bearer " + pToken);

            request = new RequestEntity(headers, pTipoTransacao, pUrl);
            return restTemplate.exchange(request, pClasse);

        } catch (Exception ex) {
            return null;
        }
    }

    public String getToken(LoginForm pLogin) {

        return fornecedorClient.autenticar(pLogin).getBody().getToken();
    }
}
