package com.example.pedidosApi.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.example.pedidosApi.entities.enums.StatusPedido;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_pedido")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long clienteId;
	private StatusPedido status;
	private Set<ItemPedido> itemsPedido = new HashSet<>();
	private Instant momento;
	
	public Pedido(Long clienteId, StatusPedido status, Set<ItemPedido> itemsPedido, Instant momento) {
		this.clienteId = clienteId;
		this.status = status.AGUARDANDO_PAGAMENTO;
		this.itemsPedido = itemsPedido;
		this.momento = Instant.now();
	}
	
	
}
