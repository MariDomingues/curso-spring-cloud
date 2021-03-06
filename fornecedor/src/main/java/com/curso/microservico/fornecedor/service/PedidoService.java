package com.curso.microservico.fornecedor.service;

import com.curso.microservico.fornecedor.model.dto.PedidoItemDto;
import com.curso.microservico.fornecedor.model.entity.PedidoEntity;
import com.curso.microservico.fornecedor.model.entity.PedidoItemEntity;
import com.curso.microservico.fornecedor.model.entity.ProdutoEntity;
import com.curso.microservico.fornecedor.repository.PedidoRepository;
import com.curso.microservico.fornecedor.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public ResponseEntity<PedidoEntity> realizaPedido(List<PedidoItemDto> pListItem) {

        if (pListItem == null) {
            return ResponseEntity.notFound().build();
        }

        List<PedidoItemEntity> vItem = toPedidoItem(pListItem);
        PedidoEntity pedido = new PedidoEntity(vItem);
        pedido.setTempoPreparo(pListItem.size());

        return ResponseEntity.ok(pedidoRepository.save(pedido));
    }

    public ResponseEntity<PedidoEntity> getPedido(Long pIdPedido) {

        return ResponseEntity.ok(pedidoRepository.findById(pIdPedido).orElse(new PedidoEntity()));
    }

    private List<PedidoItemEntity> toPedidoItem(List<PedidoItemDto> pListItem) {

        List<Long> vIdProduto = pListItem
                .stream()
                .map(item -> item.getId())
                .collect(Collectors.toList());

        List<ProdutoEntity> vProduto = produtoRepository.findByIdIn(vIdProduto);

        List<PedidoItemEntity> vItem = pListItem
                .stream()
                .map(item -> {

                    ProdutoEntity produto = vProduto
                            .stream()
                            .filter(p -> p.getId() == item.getId())
                            .findFirst().get();

                    PedidoItemEntity pedidoItem = new PedidoItemEntity();
                    pedidoItem.setProduto(produto);
                    pedidoItem.setQuantidade(item.getQuantidade());

                    return pedidoItem;

                })
                .collect(Collectors.toList());

        return vItem;
    }
}
