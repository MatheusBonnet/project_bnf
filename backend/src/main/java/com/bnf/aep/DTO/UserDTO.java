package com.bnf.aep.DTO;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserDTO extends RepresentationModel<UserDTO>{
	
	private Long id;
	
	private String nome;

	private Long cpf;

	private String email;
	
	private String senha;
	

}
