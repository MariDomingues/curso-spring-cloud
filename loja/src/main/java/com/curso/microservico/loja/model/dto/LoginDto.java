package com.curso.microservico.loja.model.dto;

import com.curso.microservico.loja.model.entity.LoginEntity;
import com.curso.microservico.loja.model.form.LoginForm;

public class LoginDto {

    private String username;
    private String password;

    public LoginDto(LoginEntity pLogin) {

        this.username = pLogin.getUsername();
        this.password = pLogin.getPassword();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
