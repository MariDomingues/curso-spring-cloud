package com.curso.microservico.loja.model.dto;

public class FornecedorInformacaoDto {

    private String endereco;

    public FornecedorInformacaoDto(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }
}
