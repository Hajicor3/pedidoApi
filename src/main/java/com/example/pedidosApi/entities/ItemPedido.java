package com.example.pedidosApi.entities;

import java.io.Serializable;

import com.example.pedidosApi.entities.pk.ItemPedidoPK;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_item_pedido")
@Data
public class ItemPedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemPedidoPK id;
	
	@Embedded
	private Produto produto;
	private Long quantidade;
	

	//metodo de multiplicar a quantidade pelo valor.
	public Double totalPedido() {
		return produto.getPreco() * quantidade;
	}

}
