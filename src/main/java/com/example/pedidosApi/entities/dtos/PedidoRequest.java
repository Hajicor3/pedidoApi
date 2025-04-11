package com.example.pedidosApi.entities.dtos;

import java.util.HashSet;
import java.util.Set;

import com.example.pedidosApi.entities.Pagamento;
import com.example.pedidosApi.entities.enums.StatusPedido;

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
	private StatusPedido status;
	private Pagamento pagamento;
	private Set<ItemPedidoRequest> items= new HashSet<>();
}
