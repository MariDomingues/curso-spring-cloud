package com.curso.microservico.loja.service;

import com.curso.microservico.loja.model.dto.CompraDto;
import com.curso.microservico.loja.model.dto.fornecedor.FornecedorDto;
import com.curso.microservico.loja.model.dto.fornecedor.PedidoDto;
import com.curso.microservico.loja.model.form.CompraForm;
import com.curso.microservico.loja.model.form.CompraItemDto;
import com.curso.microservico.loja.model.form.LoginForm;
import com.curso.microservico.loja.repository.CompraRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {

    private static final Logger log = LoggerFactory.getLogger(CompraService.class);

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ApiService apiService;

//    @CircuitBreaker(name = "realizaCompra", fallbackMethod = "fallbackForCreateRequest")
    @Retry(name = "realizaCompra", fallbackMethod = "fallbackForCreateRequest")
    public ResponseEntity realizaCompra(CompraForm pCompra) throws Exception {

        log.info("Buscando informações do Fornecedor de {}", pCompra.getEndereco().getEstado());

        FornecedorDto fornecedorInformacao = (FornecedorDto) getEnderecoFornecedor(pCompra.getLogin(), pCompra.getEndereco().getEstado());

        log.info("Realizando Pedido!");
        PedidoDto pedidoInfo = setPedido(pCompra.getLogin(), pCompra.getvItem());

        CompraDto compra = new CompraDto();
        compra.setIdPedido(pedidoInfo.getId());
        compra.setTempoPreparo(pedidoInfo.getTempoPreparo());
        compra.setEnderecoDestino(pCompra.getEndereco());

        return ResponseEntity.ok(compra);
    }

    public FornecedorDto getEnderecoFornecedor(LoginForm pLogin, String pEstado) {

        return (FornecedorDto) apiService.getEnderecoFornecedor(pLogin, pEstado);
    }

    private PedidoDto setPedido(LoginForm pLogin, List<CompraItemDto> pListItem) throws Exception {

        return apiService.setPedido(pLogin, pListItem);
    }

    public ResponseEntity fallbackForCreateRequest(CompraForm pCompra, Exception pException) {

        log.error("Inside circuit breaker fallbackForCreateRequest, cause - {}", pException.toString());

        return ResponseEntity.badRequest().body("Inside circuit breaker fallback method. Some error occurred while calling service for buy");
    }
}