package com.example.pedidosApi.repositories.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.pedidosApi.entities.Produto;
import com.example.pedidosApi.entities.dtos.MovimentacaoRequest;

@FeignClient(name = "apiprodutos", url = "${api.produtos.url}")
public interface ProdutosRepository {
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> pegarProduto(@PathVariable Long id);
	
	@PostMapping(value = "/movimentacao")
	public ResponseEntity<MovimentacaoRequest> registrarMovimentacaoDeProduto(@RequestBody MovimentacaoRequest movimentacaoRequest);
}

