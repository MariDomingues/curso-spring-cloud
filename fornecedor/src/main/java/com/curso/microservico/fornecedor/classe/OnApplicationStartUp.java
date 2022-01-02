package com.curso.microservico.fornecedor.classe;

import com.curso.microservico.fornecedor.model.entity.FornecedorEntity;
import com.curso.microservico.fornecedor.model.entity.LoginEntity;
import com.curso.microservico.fornecedor.model.entity.ProdutoEntity;
import com.curso.microservico.fornecedor.repository.FornecedorRepository;
import com.curso.microservico.fornecedor.repository.LoginRepository;
import com.curso.microservico.fornecedor.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OnApplicationStartUp {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

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

        if (produtoRepository.findAll().isEmpty()) {

            ProdutoEntity produto = new ProdutoEntity();
            produto.setNome("Rosas");
            produto.setDescricao("Buquê de Rosas");
            produto.setEstado("SP");
            produto.setPreco(BigDecimal.valueOf(59.99));

            produtoRepository.save(produto);

            produto = new ProdutoEntity();
            produto.setNome("Orquídea");
            produto.setDescricao("Vaso de Orquídea");
            produto.setEstado("SP");
            produto.setPreco(BigDecimal.valueOf(25));

            produtoRepository.save(produto);

            produto = new ProdutoEntity();
            produto.setNome("Girassol");
            produto.setDescricao("Vaso de Girassol");
            produto.setEstado("SP");
            produto.setPreco(BigDecimal.valueOf(10));

            produtoRepository.save(produto);
        }
    }
}
