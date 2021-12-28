package com.curso.microservico.loja.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "compra")
public class CompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item")
    @OneToMany(mappedBy = "compra")
    private List<CompraItemEntity> vItem = new ArrayList<>();

    @OneToOne
    private EnderecoEntity endereco;

    public Long getId() {
        return id;
    }

    public List<CompraItemEntity> getvItem() {
        return vItem;
    }

    public void setvItem(List<CompraItemEntity> vItem) {
        this.vItem = vItem;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }
}
