package com.curso.microservico.loja.model.dto.fornecedor;

import com.curso.microservico.loja.model.enums.PedidoStatus;

import java.util.List;

public class PedidoDto {

    private Long id;
    private Integer tempoPreparo;

    private PedidoStatus status;
    private List<PedidoItemDto> vItem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(Integer tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public PedidoStatus getStatus() {
        return status;
    }

    public void setStatus(PedidoStatus status) {
        this.status = status;
    }

    public List<PedidoItemDto> getvItem() {
        return vItem;
    }

    public void setvItem(List<PedidoItemDto> vItem) {
        this.vItem = vItem;
    }
}
