package com.example.pedidosApi.repositories.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.pedidosApi.entities.Produto;

@FeignClient(name = "apiprodutos", url = "http://localhost:8080/produtos")
public interface ProdutosRepository {
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> pegarProduto(@PathVariable Long id);
}
