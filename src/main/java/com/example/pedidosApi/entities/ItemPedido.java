package com.example.pedidosApi.entities;

import java.io.Serializable;
import java.util.Objects;

import com.example.pedidosApi.entities.pk.ItemPedidoPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_item_pedido")
@Getter
@NoArgsConstructor
public class ItemPedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();
	
	private Double preco;
	private Long quantidade;
	
	public ItemPedido(ItemPedidoPK id, Double preco, Long quantidade) {
		this.id = id;
		setPreco(preco);
		setQuantidade(quantidade);
	}

	
	public void setQuantidade(Long quantidade) {
		if(quantidade < 1 || quantidade == null) {
			throw new IllegalArgumentException("a quantidade deve ser maior que zero!");
		}
		this.quantidade = quantidade;
	}
	
	public void setPreco(Double preco) {
		if(preco == null || preco <= 0) {
			throw new IllegalArgumentException("Preço inválido!");
		}
		this.preco = preco;
	}
	
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
