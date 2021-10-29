package com.bnf.aep.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnf.aep.DTO.UserDTO;
import com.bnf.aep.model.Response;
import com.bnf.aep.services.IUserService;

@RestController
@RequestMapping("/doadores")
public class UserController {

	public static final String UPDATE = "Atualizado com sucesso.";

	public static final String DELETE = "Deletado com sucesso";
	
	@Autowired
	private IUserService userService;
		
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Response<UserDTO>> excluirConta(@PathVariable Long  id) {
		Response<UserDTO>  response = new Response<>();
		response.setData(getUserService().deletar(id));
		response.setStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Response<UserDTO>> atualizarConta(@RequestBody UserDTO user){
		Response<UserDTO> response = new Response<>();
		response.setData(getUserService().atualizarUsuario(user));
		response.setStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}


}
