package com.example.pedidosApi.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Long id) {
		super("Recurso não encontrado no ID: " + id);
	}
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
