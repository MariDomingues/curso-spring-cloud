package com.curso.microservico.loja.client;

import com.curso.microservico.loja.model.dto.PedidoInfoDto;
import com.curso.microservico.loja.model.form.CompraItemForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "pedido")
public interface PedidoClient {

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    PedidoInfoDto realizaPedido(@RequestBody List<CompraItemForm> pListProduto, @RequestHeader("Authorization") String header);
}
