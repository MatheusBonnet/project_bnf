package com.bnf.aep.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bnf.aep.DTO.ProductsDTO;
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
	public Boolean deletar(Long id) {
		try {
			this.buscaPorId(id);
			this.produtoRepository.deleteById(id);
			return Boolean.TRUE;

		} catch (ProductsException m) {
			throw m;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<ProductsDTO> listarTodas() {
		try {
			List<ProductsDTO> produto = this.mapper.map(this.produtoRepository.findAll(),
					new TypeToken<List<ProductsDTO>>() {
					}.getType());

			return produto;

		} catch (Exception e) {
			throw new ProductsException(MENSAGEM_ERRO, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public Boolean inserirDoacao(Products produtos) {
		try {
			Products produto = this.mapper.map(produtos, Products.class);
			produtoRepository.save(produto);
			return Boolean.TRUE;
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
	public Boolean atualizar(Products produtos) {
		try {

			Optional<Products> daocaoOptional = produtoRepository.findById(produtos.getId());

			if (daocaoOptional.isPresent()) {

				Products doacaoDto = this.mapper.map(daocaoOptional.get(), Products.class);

				produtoRepository.save(doacaoDto);

				throw new ProductsException(MESSAGE_ERROR_DOACAO_NOT_FOUND, HttpStatus.NOT_FOUND);
			}
			throw new ProductsException(MESSAGE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ProductsException d) {
			throw d;
		} catch (Exception e) {
			throw new ProductsException(MESSAGE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
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