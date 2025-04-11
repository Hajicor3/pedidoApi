package com.example.pedidosApi.entities;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_pagamento")
@Getter
@NoArgsConstructor
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant momentoPagamento;
	
	public Pagamento(Instant momentoPagamento) {
		this.momentoPagamento = momentoPagamento;
	}
	
	public void setMomentoPagamento() {
		momentoPagamento = Instant.now();
	}
}
