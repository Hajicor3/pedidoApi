package com.example.pedidosApi.services;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.pedidosApi.entities.ItemPedido;
import com.example.pedidosApi.entities.Pedido;
import com.example.pedidosApi.entities.Produto;
import com.example.pedidosApi.entities.dtos.ItemPedidoRequest;
import com.example.pedidosApi.entities.dtos.PedidoRequest;
import com.example.pedidosApi.entities.pk.ItemPedidoPK;
import com.example.pedidosApi.repositories.PedidoRepository;
import com.example.pedidosApi.repositories.feign.ProdutosRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {
	
	private final PedidoRepository pedidoRepository;
	private final ProdutosRepository produtosRepository;
	
	public Pedido criar(PedidoRequest pedido) {
		var pedidoSalvo = new Pedido();
		pedidoSalvo.setClienteId(pedido.getClienteId());
		pedidoSalvo.setStatus(pedido.getStatus());
		pedidoSalvo.setMomento(Instant.now());
		
		Set<ItemPedido> lista = new HashSet<>();
		
		for (ItemPedidoRequest x : pedido.getItems()) {
			Produto produto = produtosRepository.pegarProduto(x.getProdutoId()).getBody();
			ItemPedido item = new ItemPedido(new ItemPedidoPK(pedidoSalvo,x.getProdutoId()),produto.getPreco(),x.getQuantidade());
			lista.add(item);
		}
		pedidoSalvo.setItemsPedido(lista);
		pedidoRepository.save(pedidoSalvo);
		return pedidoSalvo;
	}
}
