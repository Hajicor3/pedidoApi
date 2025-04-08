package com.example.pedidosApi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pedidosApi.services.PedidoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/pedidos")
@RequiredArgsConstructor
public class PedidoController {
	
	private final PedidoService pedidoService;
}
