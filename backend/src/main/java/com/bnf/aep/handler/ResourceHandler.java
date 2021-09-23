package com.bnf.aep.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bnf.aep.exception.ProductsException;
import com.bnf.aep.exception.UserException;
import com.bnf.aep.model.Response;

@ControllerAdvice
public class ResourceHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Response<Map<String, String>>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException m) {

		Map<String, String> erros = new HashMap<>();
		m.getBindingResult().getAllErrors().forEach(erro -> {
			String campo = ((FieldError) erro).getField();
			String mensagem = erro.getDefaultMessage();
			erros.put(campo, mensagem);
		});
	
		Response<Map<String, String>> response = new Response<>();
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setData(erros);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

	}

	@ExceptionHandler(ProductsException.class)
	public ResponseEntity<Response<String>> handlerDoacaoException(ProductsException produtoException) {
		Response<String> response = new Response<String>();
		response.setStatusCode(produtoException.getHttpStatus().value());
		response.setData(produtoException.getMessage());
		return ResponseEntity.status(produtoException.getHttpStatus()).body(response);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<Response<String>> handlerDoadorException(UserException doadorException) {
		Response<String> response = new Response<String>();
		response.setStatusCode(doadorException.getHttpStatus().value());
		response.setData(doadorException.getMessage());
		return ResponseEntity.status(doadorException.getHttpStatus()).body(response);
	}
}
