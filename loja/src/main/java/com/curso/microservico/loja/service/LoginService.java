package com.curso.microservico.loja.service;

import com.curso.microservico.loja.model.dto.LoginDto;
import com.curso.microservico.loja.model.entity.LoginEntity;
import com.curso.microservico.loja.model.form.LoginForm;
import com.curso.microservico.loja.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public LoginEntity insert(LoginForm pLogin) {

        LoginEntity login = new LoginEntity(pLogin);
        loginRepository.save(login);

        return login;
    }

    public ResponseEntity<LoginDto> carregar(Long pIdLogin) {

        Optional<LoginEntity> loginConsulta = loginRepository.findById(pIdLogin);

        if (loginConsulta.isPresent()) {

            return ResponseEntity.ok(new LoginDto(loginConsulta.get()));
        }

        return ResponseEntity.badRequest().build();
    }
}
