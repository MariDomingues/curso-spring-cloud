package com.curso.microservico.loja.model.entity;

import com.curso.microservico.loja.model.form.LoginForm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "loginLoja")
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    public LoginEntity() {
    }

    public LoginEntity(LoginForm pLogin) {

        setUsername(pLogin.getUsuario());
        setPassword(pLogin.getSenha());
    }

    public Long getId() {
        return id;
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

        this.password = new BCryptPasswordEncoder().encode(password);
    }
}
