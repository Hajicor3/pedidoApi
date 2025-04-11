package com.example.pedidosApi.entities.dtos;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.example.pedidosApi.entities.Pagamento;
import com.example.pedidosApi.entities.enums.StatusPedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponse {
	
	private Long id;
	private Long clienteId;
	private StatusPedido status;
	private Pagamento pagamento;
	private Set<ItemPedidoResponse> itemsPedido = new HashSet<>();
	private Instant momento;
}
