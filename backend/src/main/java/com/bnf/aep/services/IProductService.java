package com.bnf.aep.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bnf.aep.DTO.ProductsDTO;
import com.bnf.aep.entities.Products;

public interface IProductService {

	public Boolean atualizar(final Products produtos);
	
	public Boolean deletar(final Long id);
	
	public Page<ProductsDTO> listarTodas(Pageable page);
	
	public Products buscaPorId(final Long id);
	
	public Boolean inserirDoacao(final Products produtos);

	List<Products> buscaPeloNome(String nome);
}
