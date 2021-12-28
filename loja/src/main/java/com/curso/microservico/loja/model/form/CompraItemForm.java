package com.curso.microservico.loja.model.form;

public class CompraItemForm {

    private long id;
    private long quantidade;

    public CompraItemForm(long id, long quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }
}
