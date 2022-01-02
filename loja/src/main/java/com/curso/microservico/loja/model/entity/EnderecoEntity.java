package com.curso.microservico.loja.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "compra")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rua;
    private long numero;
    private String estado;

    @OneToOne
    @JoinColumn(name = "compra_id")
    private CompraEntity compra;

    public CompraEntity getCompra() {
        return compra;
    }

    public Long getId() {
        return id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCompra(CompraEntity compra) {
        this.compra = compra;
    }
}
