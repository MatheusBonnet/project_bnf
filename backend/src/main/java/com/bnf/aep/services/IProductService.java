package com.bnf.aep.services;

import java.util.List;

import com.bnf.aep.entities.Products;

public interface IProductService {

	public Products atualizar(final Products produtos);
	
	public Products deletar(final Long id);
	
	public Products listarTodas();
	
	public Products buscaPorId(final Long id);
	
	public Products inserirDoacao(final Products produtos);

	List<Products> buscaPeloNome(String nome);
}
