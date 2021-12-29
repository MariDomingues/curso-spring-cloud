package com.curso.microservico.fornecedor.classe;

import com.curso.microservico.fornecedor.model.entity.FornecedorInformacaoEntity;
import com.curso.microservico.fornecedor.model.entity.LoginEntity;
import com.curso.microservico.fornecedor.repository.FornecedorInformacaoRepository;
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
    private FornecedorInformacaoRepository fornecedorInformacaoRepository;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (loginRepository.findAll().isEmpty()) {

            LoginEntity usuario = new LoginEntity();
            usuario.setUsuario("admin");
            usuario.setSenha("123");

            loginRepository.save(usuario);
        }

        if (fornecedorInformacaoRepository.findAll().isEmpty()) {

            FornecedorInformacaoEntity fornecedorInformacao = new FornecedorInformacaoEntity();
            fornecedorInformacao.setNome("Fornecedor SP");
            fornecedorInformacao.setEndereco("Endereco Fornecedor SP");
            fornecedorInformacao.setEstado("SP");

            fornecedorInformacaoRepository.save(fornecedorInformacao);

            fornecedorInformacao = new FornecedorInformacaoEntity();
            fornecedorInformacao.setNome("Fornecedor MG");
            fornecedorInformacao.setEndereco("Endereco Fornecedor MG");
            fornecedorInformacao.setEstado("MG");

            fornecedorInformacaoRepository.save(fornecedorInformacao);

            fornecedorInformacao = new FornecedorInformacaoEntity();
            fornecedorInformacao.setNome("Fornecedor RJ");
            fornecedorInformacao.setEndereco("Endereco Fornecedor RJ");
            fornecedorInformacao.setEstado("RJ");

            fornecedorInformacaoRepository.save(fornecedorInformacao);
        }
    }
}
