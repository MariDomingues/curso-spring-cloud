package com.curso.microservico.fornecedor.model.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "loginFornecedor")
public class LoginEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String usuario;
    private String senha;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<PerfilEntity> vPerfil = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {

        this.senha = new BCryptPasswordEncoder().encode(senha);
    }

    public List<PerfilEntity> getvPerfil() {
        return vPerfil;
    }

    public void setvPerfil(List<PerfilEntity> vPerfil) {
        this.vPerfil = vPerfil;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return this.getvPerfil();
    }

    @Override
    public String getPassword() {

        return this.getSenha();
    }

    @Override
    public String getUsername() {

        return this.getUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }
}
