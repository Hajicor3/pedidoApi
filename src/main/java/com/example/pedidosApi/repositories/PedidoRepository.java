package com.example.pedidosApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pedidosApi.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
