package com.bnf.aep.exception;

import org.springframework.http.HttpStatus;

public class UserException extends RuntimeException{

	private static final long serialVersionUID = -7743596026025818874L;
	
	private final HttpStatus httpStatus;

	public UserException(final String message, final HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
