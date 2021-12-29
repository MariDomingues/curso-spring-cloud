package com.curso.microservico.loja.service;

import com.curso.microservico.loja.interfaces.GenericResponse;
import com.curso.microservico.loja.model.dto.TokenDto;
import com.curso.microservico.loja.model.form.LoginForm;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class ApiService {

    private RequestEntity request;

    public GenericResponse enviarDados(String pUrl, LoginForm pLogin, GenericResponse pDadosResposta, HttpMethod pTipoTransacao) throws Exception {

        ResponseEntity<GenericResponse> retorno = postHttps(new URI(pUrl), pLogin, pDadosResposta.getClass(), pTipoTransacao);

        if (retorno != null && (retorno.getStatusCode() == HttpStatus.OK || retorno.getStatusCode() == HttpStatus.ALREADY_REPORTED)) {
            return retorno.getBody();

        } else {
            return null;
        }
    }

    protected ResponseEntity postHttps(URI pUrl, LoginForm pLogin, Class<?> pClasse, HttpMethod pTipoTransacao) throws Exception {

        try {
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE.toString());
            headers.add("Authorization", "Bearer " + getToken(pUrl, pLogin));

            request = new RequestEntity(headers, pTipoTransacao, pUrl);
            return new RestTemplate().exchange(request, pClasse);

        } catch (Exception ex) {
            return null;
        }
    }

    protected String getToken(URI pUrl, LoginForm pLogin) throws Exception {

        request = new RequestEntity(pLogin, HttpMethod.POST, new URI("http://localhost:8081/auth"));
        return new RestTemplate().exchange(request, TokenDto.class).getBody().getToken();
    }
}
