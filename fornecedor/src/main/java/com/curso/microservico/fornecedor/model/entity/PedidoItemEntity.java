package com.curso.microservico.fornecedor.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "pedidoitem")
public class PedidoItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer quantidade;
	
	@ManyToOne @JoinColumn(name = "id_produto")
	private ProdutoEntity produto;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public Integer getQuantidade() {

		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {

		this.quantidade = quantidade;
	}

	public ProdutoEntity getProduto() {

		return produto;
	}

	public void setProduto(ProdutoEntity produto) {

		this.produto = produto;
	}
}
