package com.curso.microservico.loja.service;

import com.curso.microservico.loja.model.dto.CompraDto;
import com.curso.microservico.loja.model.dto.FornecedorDto;
import com.curso.microservico.loja.model.dto.PedidoInfoDto;
import com.curso.microservico.loja.model.form.CompraForm;
import com.curso.microservico.loja.model.form.CompraItemForm;
import com.curso.microservico.loja.model.form.LoginForm;
import com.curso.microservico.loja.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ApiService apiService;

    public ResponseEntity<CompraDto> realizaCompra(CompraForm pCompra) throws Exception {

        try {

            FornecedorDto fornecedorInformacao = (FornecedorDto) getEnderecoFornecedor(pCompra.getLogin(), pCompra.getEndereco().getEstado());

            PedidoInfoDto pedidoInfo = setPedido(pCompra.getLogin(), pCompra.getvItem());

            CompraDto compra = new CompraDto();
            compra.setIdPedido(pedidoInfo.getId());
            compra.setTempoPreparo(pedidoInfo.getTempoPreparo());
            compra.setEnderecoDestino(pCompra.getEndereco());

            return ResponseEntity.ok(compra);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public FornecedorDto getEnderecoFornecedor(LoginForm pLogin, String pEstado) throws Exception {

        return (FornecedorDto) apiService.getEnderecoFornecedor(pLogin, pEstado);
    }

    private PedidoInfoDto setPedido(LoginForm pLogin, List<CompraItemForm> pListItem) {

        return apiService.setPedido(pLogin, pListItem);
    }
}