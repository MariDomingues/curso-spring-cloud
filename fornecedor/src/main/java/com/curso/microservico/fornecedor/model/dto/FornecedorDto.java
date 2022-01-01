package com.curso.microservico.fornecedor.model.dto;

import com.curso.microservico.fornecedor.model.entity.FornecedorEntity;

public class FornecedorDto {

    private String nome;
    private String estado;
    private String endereco;

    public FornecedorDto(FornecedorEntity pInformacao) {

        this.nome = pInformacao.getNome();
        this.estado = pInformacao.getEstado();
        this.endereco = pInformacao.getEndereco();
    }

    public String getNome() {
        return nome;
    }

    public String getEstado() {
        return estado;
    }

    public String getEndereco() {
        return endereco;
    }
}
