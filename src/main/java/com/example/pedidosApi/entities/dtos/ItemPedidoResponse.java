package com.example.pedidosApi.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemPedidoResponse {
	
	private Long produtoId;
	private String nome;
	private Long quantidade;
	private Double preco;
}
