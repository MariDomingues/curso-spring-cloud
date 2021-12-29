package com.curso.microservico.loja.model.form;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.ArrayList;
import java.util.List;

public class CompraForm {

    @JsonAlias("itens")
    private List<CompraItemForm> vItem = new ArrayList<>();
    private EnderecoForm endereco;
    private LoginForm login;

    public List<CompraItemForm> getvItem() {
        return vItem;
    }

    public void setvItem(List<CompraItemForm> vItem) {
        this.vItem = vItem;
    }

    public EnderecoForm getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoForm endereco) {
        this.endereco = endereco;
    }

    public LoginForm getLogin() {
        return login;
    }

    public void setLogin(LoginForm login) {
        this.login = login;
    }
}
