package com.example.pedidosApi.entities.pk;

import com.example.pedidosApi.entities.Pedido;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ItemPedidoPK {
	
	private Pedido idPedido;
	private Long idProduto;
}
