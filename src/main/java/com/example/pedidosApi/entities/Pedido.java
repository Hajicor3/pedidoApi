package com.example.pedidosApi.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.example.pedidosApi.entities.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_pedido")
@Getter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long clienteId;
	private StatusPedido status;
	private Pagamento pagamento;
	@OneToMany(mappedBy = "id.pedido", cascade = CascadeType.ALL)
	private Set<ItemPedido> itemsPedido = new HashSet<>();
	private Instant momento;
	
	public Pedido(Long clienteId, StatusPedido status, Set<ItemPedido> itemsPedido, Pagamento pagamento) {
		setClienteId(clienteId);
		setStatus(status);
		if(pagamento != null) {
			registrarPagamento(pagamento);
		}

		this.itemsPedido = new HashSet<>();
		if(itemsPedido != null) {
			this.itemsPedido.addAll(itemsPedido);
		}
		
		this.momento = Instant.now();
	}

	public void setClienteId(Long clientId) {
		if(clientId <= 0 || clientId == null) {
			throw new IllegalArgumentException("O id deve ser um id válido!");
		}
		this.clienteId = clientId;
	}
	
	public void setStatus(StatusPedido status) {
		Objects.requireNonNull(status, "O status não pode ser nulo!");
		this.status = status;
	}
	
	public void registrarPagamento(Pagamento pagamento) {
		Objects.requireNonNull(pagamento, "Pagamento inválido");
		this.pagamento = pagamento;
		status = StatusPedido.PAGO;
	}
	
	public void adicionarItem(ItemPedido itemPedido) {
		Objects.requireNonNull(itemPedido, "Item inválido");
		itemsPedido.add(itemPedido);
	}
	
	public void removerItem(ItemPedido itemPedido) {
		Objects.requireNonNull(itemPedido, "Item inválido");
		itemsPedido.remove(itemPedido);
	}
	
	public void atualizarMomento() {
		this.momento = Instant.now();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
