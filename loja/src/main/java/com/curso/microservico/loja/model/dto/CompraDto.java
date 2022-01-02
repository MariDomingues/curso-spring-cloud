package com.curso.microservico.loja.model.dto;

import com.curso.microservico.loja.model.form.EnderecoForm;

public class CompraDto {

    private Long idPedido;
    private Integer tempoPreparo;
    private EnderecoForm enderecoDestino;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(Integer tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public EnderecoForm getEnderecoDestino() {
        return enderecoDestino;
    }

    public void setEnderecoDestino(EnderecoForm enderecoDestino) {
        this.enderecoDestino = enderecoDestino;
    }
}
