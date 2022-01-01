package com.curso.microservico.loja.model.dto;

import com.curso.microservico.loja.interfaces.GenericResponse;

public class FornecedorInformacaoDto implements GenericResponse {

    private String nome;
    private String estado;
    private String endereco;

    public FornecedorInformacaoDto() {
    }

    public FornecedorInformacaoDto(String nome, String estado, String endereco) {
        this.nome = nome;
        this.estado = estado;
        this.endereco = endereco;
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
