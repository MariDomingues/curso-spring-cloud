package com.curso.microservico.fornecedor.service;

import com.curso.microservico.fornecedor.model.entity.LoginEntity;
import com.curso.microservico.fornecedor.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {
    //contém a lógica para validar as credenciais de um cliente que está se autenticando.

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String pUsername) throws UsernameNotFoundException {

        Optional<LoginEntity> usuarioConsulta = loginRepository.findByUsuario(pUsername);

        if (usuarioConsulta.isPresent()) {

            return usuarioConsulta.get();
        }

        throw new UsernameNotFoundException("Dados Inválidos!");
    }
}
