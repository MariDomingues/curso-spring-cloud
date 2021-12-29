package com.curso.microservico.fornecedor.service;

import com.curso.microservico.fornecedor.model.entity.LoginEntity;
import com.curso.microservico.fornecedor.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public LoginEntity getUsuario(long pIdUsuario) {

        return loginRepository.findById(pIdUsuario).get();
    }
}
