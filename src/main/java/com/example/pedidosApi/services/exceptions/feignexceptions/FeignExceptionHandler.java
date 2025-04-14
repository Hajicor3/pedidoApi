package com.example.pedidosApi.services.exceptions.feignexceptions;

import lombok.Getter;

public class FeignExceptionHandler extends RuntimeException {
private static final long serialVersionUID = 1L;
	
	@Getter
	private int statusCode;
	
	public FeignExceptionHandler(int statusCode, String msg) {
		super(msg);
		this.statusCode = statusCode;
	}
}
