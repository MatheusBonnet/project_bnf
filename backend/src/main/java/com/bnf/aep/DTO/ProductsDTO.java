package com.bnf.aep.DTO;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductsDTO extends RepresentationModel<ProductsDTO>{
	
	private Long id;
	
	private String descricao;

	private Long telefone;

	private String produto;

	private String endereco;
	
	private String bairro;
	

}
