package com.example.pedidosApi.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nomeProduto;
	private Double preco;
}
