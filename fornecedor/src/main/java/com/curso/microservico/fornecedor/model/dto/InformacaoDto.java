package com.curso.microservico.fornecedor.model.dto;

import com.curso.microservico.fornecedor.model.entity.InformacaoEntity;

public class InformacaoDto {

    private String nome;
    private String estado;
    private String endereco;

    public InformacaoDto(InformacaoEntity pInformacao) {

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
