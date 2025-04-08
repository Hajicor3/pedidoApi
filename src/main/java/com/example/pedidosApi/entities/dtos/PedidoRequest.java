package com.example.pedidosApi.entities.dtos;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PedidoRequest {
	
	private Long clienteId;
	private Set<ItemPedidoRequest> items= new HashSet<>();
}
