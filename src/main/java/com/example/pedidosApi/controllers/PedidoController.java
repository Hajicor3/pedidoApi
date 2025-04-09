package com.example.pedidosApi.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.pedidosApi.entities.Pedido;
import com.example.pedidosApi.entities.dtos.PedidoRequest;
import com.example.pedidosApi.services.PedidoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/pedidos")
@RequiredArgsConstructor
public class PedidoController {
	
	private final PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<Pedido> criarPedido(@RequestBody PedidoRequest pedido) {
		var pedidoSalvo = pedidoService.criar(pedido);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(pedidoSalvo.getId()).toUri();
		return ResponseEntity.created(uri).body(pedidoSalvo);
	}
}
