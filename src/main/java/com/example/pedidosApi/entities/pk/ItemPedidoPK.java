	package com.example.pedidosApi.entities.pk;
	
	import java.io.Serializable;
import java.util.Objects;

import com.example.pedidosApi.entities.Pedido;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
	
	@Embeddable
	@Getter
	@NoArgsConstructor
	public class ItemPedidoPK implements Serializable{
		private static final long serialVersionUID = 1L;
		
		@ManyToOne
		@JsonIgnore
		@JoinColumn(name = "id_pedido")
		private Pedido pedido;
		private Long idProduto;
		
		public ItemPedidoPK(Long idProduto, Pedido pedido) {
			this.idProduto = Objects.requireNonNull(idProduto, "O ID do produto não pode ser nulo!");
			this.pedido = Objects.requireNonNull(pedido, "O pedido não pode ser nulo!");
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ItemPedidoPK other = (ItemPedidoPK) obj;
			return Objects.equals(pedido, other.pedido) && Objects.equals(idProduto, other.idProduto);
		}
		@Override
		public int hashCode() {
			return Objects.hash(pedido, idProduto);
		}
		
		
	}
