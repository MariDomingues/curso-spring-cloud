package com.curso.microservico.fornecedor.model.entity;

import com.curso.microservico.fornecedor.model.enums.PedidoStatus;
import com.fasterxml.jackson.annotation.JsonAlias;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pedido")
public class PedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer tempoDePreparo;

	@Enumerated(EnumType.STRING)
	private PedidoStatus status;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pedidoId")
	@JsonAlias("itens")
	private List<PedidoItemEntity> vItem;

	public PedidoEntity(List<PedidoItemEntity> pListItem) {

		this.vItem = pListItem;
		this.status = PedidoStatus.RECEBIDO;
	}

	public PedidoEntity() {
	}

	public List<PedidoItemEntity> getvItem() {

		return vItem;
	}

	public void setvItem(List<PedidoItemEntity> vItem) {

		this.vItem = vItem;
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public PedidoStatus getStatus() {

		return status;
	}

	public void setStatus(PedidoStatus status) {

		this.status = status;
	}

	public Integer getTempoDePreparo() {

		return tempoDePreparo;
	}

	public void setTempoDePreparo(Integer tempoDePreparo) {

		this.tempoDePreparo = tempoDePreparo;
	}
}
