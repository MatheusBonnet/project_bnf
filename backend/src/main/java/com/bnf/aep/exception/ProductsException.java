package com.bnf.aep.exception;

import org.springframework.http.HttpStatus;

public class ProductsException extends RuntimeException{

	private static final long serialVersionUID = -3732539269781027203L;

	private final HttpStatus httpStatus;

	public ProductsException (final String message, final HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
