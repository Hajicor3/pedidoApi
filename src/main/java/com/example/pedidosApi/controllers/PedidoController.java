package com.example.pedidosApi.controllers;

import java.net.URI;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.pedidosApi.entities.ItemPedido;
import com.example.pedidosApi.entities.dtos.PedidoRequest;
import com.example.pedidosApi.entities.dtos.PedidoResponse;
import com.example.pedidosApi.services.PedidoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/pedidos")
@RequiredArgsConstructor
public class PedidoController {
	
	private final PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<PedidoResponse> criarPedido(@RequestBody PedidoRequest pedido) {
		var pedidoSalvo = pedidoService.criar(pedido);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedidoSalvo.getId()).toUri();
		return ResponseEntity.created(uri).body(pedidoSalvo);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PedidoResponse> resgatarPedidoPorId(@PathVariable Long id) {
		
		var pedido = pedidoService.resgatarPedido(id);
		return ResponseEntity.ok().body(pedido);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletarPedidoPeloId(@PathVariable Long id) {
		pedidoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/add/{id}")
	public ResponseEntity<Void> adicionarItemPedido(@RequestBody Set<ItemPedido> item, @PathVariable Long id) {
		pedidoService.adicionarItem(item, id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/rmv/{id}")
	public ResponseEntity<Void> removerItemPedido(@RequestBody Set<ItemPedido> item, @PathVariable Long id) {
		pedidoService.removerItem(item, id);
		return ResponseEntity.noContent().build();
	}
}
