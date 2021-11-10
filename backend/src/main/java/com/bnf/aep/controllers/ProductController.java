package com.bnf.aep.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnf.aep.entities.Products;
import com.bnf.aep.model.Response;
import com.bnf.aep.repositories.IProductRepository;
import com.bnf.aep.services.IProductService;

@RestController
@RequestMapping("/produtos")
public class ProductController {

	public static final String UPDATE = "Atualizado com sucesso.";

	public static final String DELETE = "Deletado com sucesso";


	@Autowired
	private IProductService produtoService;
	
	@Autowired
	private IProductRepository repository;

	@GetMapping
	public ResponseEntity<Response<List<Products>>> listarDoacoes() {
		Response<List<Products>> response = new Response<>();
		response.setData(this.repository.findAll());
		response.setStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Response<Products>> atualizarDoacao( @RequestBody Products doacao){
		Response<Products> response = new Response<>();
		response.setData(this.produtoService.atualizar(doacao));
		response.setStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping
	public ResponseEntity<Response<Products>> inserirDoacao(@RequestBody Products doacao) {
		Response<Products> response = new Response<>();
		response.setData(this.produtoService.inserirDoacao(doacao));
		response.setStatusCode(HttpStatus.CREATED.value());
		response.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).inserirDoacao(doacao)).withSelfRel());
		response.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).atualizarDoacao(doacao)).withRel(UPDATE));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Response<Products>> excluirDoacao(@PathVariable Long id) {
		Response<Products> response = new Response<>();
		response.setData(this.produtoService.deletar(id));
		response.setStatusCode(HttpStatus.OK.value());
		response.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).excluirDoacao(id)).withSelfRel());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/nome-produto/{nome}")
	public ResponseEntity<Response<List<Products>>> consultaDoacaoPorNome(@PathVariable String nome) {
		Response<List<Products>> response = new Response<>();
		List<Products> materia = this.produtoService.buscaPeloNome(nome);
		response.setData(materia);
		response.setStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
