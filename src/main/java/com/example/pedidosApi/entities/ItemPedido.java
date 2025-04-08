package com.example.pedidosApi.entities;

import java.io.Serializable;

import com.example.pedidosApi.entities.pk.ItemPedidoPK;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class ItemPedido implements Serializable{
	private static final long serialVersionUID = 1L;

	private ItemPedidoPK id;
	
	private Produto produto;
	private Long quantidade;
	

	//metodo de multiplicar a quantidade pelo valor.
	public Double totalPedido() {
		return produto.getPreco() * quantidade;
	}

}
