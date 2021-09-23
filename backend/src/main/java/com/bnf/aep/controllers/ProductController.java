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

import com.bnf.aep.DTO.ProductsDTO;
import com.bnf.aep.entities.Products;
import com.bnf.aep.model.Response;

@RestController
@RequestMapping("/produtos")
public class ProductController {

	public static final String UPDATE = "Atualizado com sucesso.";

	public static final String DELETE = "Deletado com sucesso";

	private static final String LIST = "GET_ALL";

	@Autowired
	private com.bnf.aep.services.IProductService produtoService;

	@GetMapping
	public ResponseEntity<Response<List<ProductsDTO>>> listarDoacoes() {
		Response<List<ProductsDTO>> response = new Response<>();
		response.setData(this.produtoService.listarTodas());
		response.setStatusCode(HttpStatus.OK.value());
		response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).listarDoacoes())
				.withSelfRel());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Response<Boolean>> atualizarDoacao( @RequestBody Products doacaoDTO){
		Response<Boolean> response = new Response<>();
		response.setData(this.produtoService.atualizar(doacaoDTO));
		response.setStatusCode(HttpStatus.OK.value());
		response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).atualizarDoacao(doacaoDTO))
				.withSelfRel());
		response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).
				listarDoacoes()).withRel(LIST));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping
	public ResponseEntity<Response<Boolean>> inserirDoacao(@RequestBody Products doacaoDTO) {
		Response<Boolean> response = new Response<>();
		response.setData(this.produtoService.inserirDoacao(doacaoDTO));
		response.setStatusCode(HttpStatus.CREATED.value());
		response.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).inserirDoacao(doacaoDTO)).withSelfRel());
		response.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).atualizarDoacao(doacaoDTO)).withRel(UPDATE));
		response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).listarDoacoes())
				.withRel(LIST));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Response<Boolean>> excluirMateria(@PathVariable Long id) {
		Response<Boolean> response = new Response<>();
		response.setData(this.produtoService.deletar(id));
		response.setStatusCode(HttpStatus.OK.value());
		response.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).excluirMateria(id)).withSelfRel());
		response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).listarDoacoes())
				.withRel(LIST));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/nome-produto/{nome}")
	public ResponseEntity<Response<List<Products>>> consultaDoacaoPorNome(@PathVariable String nome) {
		Response<List<Products>> response = new Response<>();
		List<Products> materia = this.produtoService.buscaPeloNome(nome);
		response.setData(materia);
		response.setStatusCode(HttpStatus.OK.value());
		response.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).consultaDoacaoPorNome(nome))
				.withSelfRel());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
