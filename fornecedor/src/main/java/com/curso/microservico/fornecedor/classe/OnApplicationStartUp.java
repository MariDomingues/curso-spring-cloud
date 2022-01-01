package com.curso.microservico.fornecedor.classe;

import com.curso.microservico.fornecedor.model.entity.FornecedorEntity;
import com.curso.microservico.fornecedor.model.entity.LoginEntity;
import com.curso.microservico.fornecedor.repository.FornecedorRepository;
import com.curso.microservico.fornecedor.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OnApplicationStartUp {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (loginRepository.findAll().isEmpty()) {

            LoginEntity usuario = new LoginEntity();
            usuario.setUsuario("admin");
            usuario.setSenha("123");

            loginRepository.save(usuario);
        }

        if (fornecedorRepository.findAll().isEmpty()) {

            FornecedorEntity fornecedorInformacao = new FornecedorEntity();
            fornecedorInformacao.setNome("Fornecedor SP");
            fornecedorInformacao.setEndereco("Endereco Fornecedor SP");
            fornecedorInformacao.setEstado("SP");

            fornecedorRepository.save(fornecedorInformacao);

            fornecedorInformacao = new FornecedorEntity();
            fornecedorInformacao.setNome("Fornecedor MG");
            fornecedorInformacao.setEndereco("Endereco Fornecedor MG");
            fornecedorInformacao.setEstado("MG");

            fornecedorRepository.save(fornecedorInformacao);

            fornecedorInformacao = new FornecedorEntity();
            fornecedorInformacao.setNome("Fornecedor RJ");
            fornecedorInformacao.setEndereco("Endereco Fornecedor RJ");
            fornecedorInformacao.setEstado("RJ");

            fornecedorRepository.save(fornecedorInformacao);
        }
    }
}
