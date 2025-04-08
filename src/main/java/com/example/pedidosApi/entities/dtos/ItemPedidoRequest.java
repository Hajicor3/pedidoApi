package com.example.pedidosApi.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ItemPedidoRequest {
	
	private Long produtoId;
	private Long quantidade;
}
