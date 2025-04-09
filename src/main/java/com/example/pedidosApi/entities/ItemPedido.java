package com.example.pedidosApi.entities;

import java.io.Serializable;
import java.util.Objects;

import com.example.pedidosApi.entities.pk.ItemPedidoPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_item_pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemPedidoPK id;
	
	private Double preco;
	private Long quantidade;
	

	//metodo de multiplicar a quantidade pelo valor.
	public Double totalPedido() {
		return quantidade * preco;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	
}
