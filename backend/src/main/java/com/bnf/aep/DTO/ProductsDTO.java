package com.bnf.aep.DTO;

import org.springframework.hateoas.RepresentationModel;


public class ProductsDTO extends RepresentationModel<ProductsDTO>{
	
	private Long id;
	
	private String descricao;
	
	private Double valor;

	private String produto;

	public ProductsDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductsDTO(Long id, String descricao, Double valor, String produto) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}
}
