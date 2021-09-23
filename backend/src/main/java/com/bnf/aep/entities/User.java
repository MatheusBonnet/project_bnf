package com.bnf.aep.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author matheus
 *
 */

@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 260616964148689036L;


	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	
	@JsonInclude(Include.NON_EMPTY)
	private String nome;
	
	@JsonInclude(Include.NON_EMPTY)
	private String cpf;
	
	@JsonInclude(Include.NON_EMPTY)
	private String email;
	
	@JsonInclude(Include.NON_EMPTY)
	private String endereco;
	
	@JsonInclude(Include.NON_EMPTY)
	private String password;
	
	private String token;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "doador_id")
	private List<Products> doacao;
	
	public User() {
	}

	public User(Long id, String nome, String cpf, String email, String endereco, String password, List<Products> doacao) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
		this.password = password;
		this.doacao = doacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<Products> getDoacao() {
		return doacao;
	}

}
