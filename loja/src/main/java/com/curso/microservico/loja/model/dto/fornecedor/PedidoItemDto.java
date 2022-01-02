package com.curso.microservico.loja.model.dto.fornecedor;

public class PedidoItemDto {

	private Long id;
	private Integer quantidade;
	private ProdutoDto produto;

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

	public ProdutoDto getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDto produto) {
		this.produto = produto;
	}
}
