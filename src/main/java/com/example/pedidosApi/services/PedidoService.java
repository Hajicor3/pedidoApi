package com.example.pedidosApi.services;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.pedidosApi.entities.ItemPedido;
import com.example.pedidosApi.entities.Pedido;
import com.example.pedidosApi.entities.Produto;
import com.example.pedidosApi.entities.dtos.ItemPedidoRequest;
import com.example.pedidosApi.entities.dtos.ItemPedidoResponse;
import com.example.pedidosApi.entities.dtos.PedidoRequest;
import com.example.pedidosApi.entities.dtos.PedidoResponse;
import com.example.pedidosApi.entities.pk.ItemPedidoPK;
import com.example.pedidosApi.repositories.PedidoRepository;
import com.example.pedidosApi.repositories.feign.ProdutosRepository;
import com.example.pedidosApi.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {
	
	private final PedidoRepository pedidoRepository;
	private final ProdutosRepository produtosRepository;
	
	@Transactional
	public Pedido criar(PedidoRequest pedido) {
		var pedidoSalvo = new Pedido();
		pedidoSalvo.setClienteId(pedido.getClienteId());
		pedidoSalvo.setStatus(pedido.getStatus());
		pedidoSalvo.atualizarMomento();
		
		for (ItemPedidoRequest x : pedido.getItems()) {
			Produto produto = produtosRepository.pegarProduto(x.getProdutoId()).getBody();
			ItemPedido item = new ItemPedido(new ItemPedidoPK(x.getProdutoId(),pedidoSalvo),produto.getPreco(),x.getQuantidade());
			pedidoSalvo.adicionarItem(item);
		}
		pedidoRepository.save(pedidoSalvo);
		return pedidoSalvo;
	}
	
	@Transactional
	public PedidoResponse resgatarPedido(Long id) {
		try {
		var pedido = pedidoRepository.getReferenceById(id);
		var itemPedidos = pedido.getItemsPedido().stream().map(x -> ItemPedidoResponse
				.builder()
				.preco(x.getPreco())
				.quantidade(x.getQuantidade())
				.produtoId(x.getId().getIdProduto())
				.build()).collect(Collectors.toSet());
		
		var pedidoResponse = new PedidoResponse(pedido.getId(), pedido.getClienteId(), pedido.getStatus(), itemPedidos, pedido.getMomento());
		return pedidoResponse;
		}
		catch(NullPointerException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	@Transactional
	public void deletar(Long id) {
		var pedido = pedidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		pedidoRepository.delete(pedido);
	}
	
	@Transactional
	public void adicionarItem(Set<ItemPedido> item, Long id) {
		
		try {
			var pedido = pedidoRepository.getReferenceById(id);
			
			for(ItemPedido x: item) {
				pedido.adicionarItem(x);
			}
			pedidoRepository.save(pedido);
		}
		catch(NullPointerException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	@Transactional
	public void removerItem(Set<ItemPedido> item, Long id) {
		
		try {
			var pedido = pedidoRepository.getReferenceById(id);
			
			for(ItemPedido x: item) {
				pedido.removerItem(x);
			}
			pedidoRepository.save(pedido);
		}
		catch(NullPointerException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
}
