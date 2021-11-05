package com.bnf.aep.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bnf.aep.entities.Products;
import com.bnf.aep.exception.ProductsException;
import com.bnf.aep.repositories.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	public static final String MESSAGE_ERROR = "Erro interno no servidor, consulte o suporte!!!";

	public static final String MESSAGE_ERROR_DOACAO_NOT_FOUND = "Doacao nao encontrada, tente novamente.";

	private static final String MENSAGEM_ERRO = null;

	@Autowired
	private IProductRepository produtoRepository;

	private ModelMapper mapper;

	@Autowired
	public ProductServiceImpl(IProductRepository produtoRepository) {
		this.mapper = new ModelMapper();
		this.produtoRepository = produtoRepository;
	}

	@Override
	public Products deletar(Long id) {
		try {
			this.buscaPorId(id);
			this.produtoRepository.deleteById(id);
			return null;

		} catch (ProductsException m) {
			throw m;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Products listarTodas() {
		try {
			List<Products> produto = produtoRepository.findAll();
		    return (Products) produto;

		} catch (Exception e) {
			throw new ProductsException(MENSAGEM_ERRO, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public Products inserirDoacao(Products produtos) {
		try {
			Products produto = this.mapper.map(produtos, Products.class);
			produtoRepository.save(produto);
			return produto;
		} catch (Exception e) {
			throw new ProductsException(MESSAGE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public List<Products> buscaPeloNome(String nome) {
		return null;
//
//		return this.mapper.map(this.produtoRepository.findByName(nome), new TypeToken<List<Products>>() {
//		}.getType());
	}

	@Override
	public Products atualizar(Products produtos) throws ProductsException{
		try {

			Optional<Products> daocaoOptional = produtoRepository.findById(produtos.getId());

			if (daocaoOptional.isPresent()) {

				Products doacao = new Products();
				doacao.setDescricao(produtos.getDescricao());
				doacao.setValor(produtos.getValor());
				doacao.setProduto(produtos.getProduto());
				produtoRepository.save(doacao);
				return doacao;
			}
			
			throw new ProductsException(MESSAGE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch (ProductsException d) {
			throw new ProductsException(MESSAGE_ERROR_DOACAO_NOT_FOUND, HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Products buscaPorId(Long id) {
		try {
			Optional<Products> produto = this.produtoRepository.findById(id);
			if (produto.isPresent()) {
				return this.mapper.map(produto.get(), Products.class);
			}
			throw new ProductsException(MESSAGE_ERROR_DOACAO_NOT_FOUND, HttpStatus.NOT_FOUND);
		} catch (ProductsException m) {
			throw m;
		} catch (Exception e) {
			throw new ProductsException(MESSAGE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}