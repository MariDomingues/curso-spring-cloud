package com.curso.microservico.loja.model.dto.fornecedor;

public class FornecedorDto {

    private String nome;
    private String estado;
    private String endereco;

    public FornecedorDto() {
    }

    public FornecedorDto(String nome, String estado, String endereco) {
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
