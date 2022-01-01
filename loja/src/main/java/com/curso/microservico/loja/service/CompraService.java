package com.curso.microservico.loja.service;

import com.curso.microservico.loja.model.dto.FornecedorInformacaoDto;
import com.curso.microservico.loja.model.form.CompraForm;
import com.curso.microservico.loja.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ApiService apiService;

    public ResponseEntity<FornecedorInformacaoDto> realizaCompra(CompraForm pCompra) throws Exception {

        try {

            FornecedorInformacaoDto fornecedorInformacao = (FornecedorInformacaoDto) apiService.enviarDados(pCompra.getLogin(), pCompra.getEndereco().getEstado());

            return ResponseEntity.ok(fornecedorInformacao);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}