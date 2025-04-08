package com.example.pedidosApi.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.example.pedidosApi.entities.enums.StatusPedido;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long clienteId;
	private StatusPedido status;
	private Set<ItemPedido> itemsPedido = new HashSet<>();
	private Instant momento;
	
}
