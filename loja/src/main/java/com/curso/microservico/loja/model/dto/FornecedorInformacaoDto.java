package com.curso.microservico.loja.model.dto;

import com.curso.microservico.loja.interfaces.GenericResponse;

public class FornecedorInformacaoDto implements GenericResponse {

    private String endereco;

    public FornecedorInformacaoDto(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }
}
