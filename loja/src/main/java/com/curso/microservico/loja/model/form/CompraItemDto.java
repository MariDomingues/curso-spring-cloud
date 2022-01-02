package com.curso.microservico.loja.model.form;

public class CompraItemDto {

    private long id;
    private int quantidade;

    public CompraItemDto() {
    }

    public CompraItemDto(long id, int quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
