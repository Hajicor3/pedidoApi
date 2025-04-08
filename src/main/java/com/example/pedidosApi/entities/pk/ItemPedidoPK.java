package com.example.pedidosApi.entities.pk;

import com.example.pedidosApi.entities.Pedido;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Embeddable
@Data
public class ItemPedidoPK {
	
	@ManyToOne
	private Pedido Pedido;
	private Long idProduto;
}
