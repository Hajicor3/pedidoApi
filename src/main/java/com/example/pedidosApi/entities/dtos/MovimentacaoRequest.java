package com.example.pedidosApi.entities.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovimentacaoRequest {

	private Long idProduto;
	private Long quantidade;
	private String tipoDeMovimentacao;
	
	public MovimentacaoRequest(Long idProduto, Long quantidade) {
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		tipoDeMovimentacao = "SAIDA";
	}
}
