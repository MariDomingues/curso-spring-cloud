package com.curso.microservico.loja.client;

import com.curso.microservico.loja.model.dto.fornecedor.FornecedorDto;
import com.curso.microservico.loja.model.dto.fornecedor.TokenDto;
import com.curso.microservico.loja.model.dto.fornecedor.PedidoDto;
import com.curso.microservico.loja.model.form.CompraItemDto;
import com.curso.microservico.loja.model.form.LoginForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "fornecedor")
public interface FornecedorClient {

    @RequestMapping(method = RequestMethod.POST, value = "auth")
    ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm pLogin);

    @RequestMapping(method = RequestMethod.GET, value = "info/{estado}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<FornecedorDto> getInformacao(@PathVariable("estado") String pEstado, @RequestHeader("Authorization") String header);

    @RequestMapping(method = RequestMethod.POST, value = "pedido", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PedidoDto> realizaPedido(@RequestBody List<CompraItemDto> pListProduto, @RequestHeader("Authorization") String header);
}
