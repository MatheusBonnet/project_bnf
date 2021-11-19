
package com.bnf.aep.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author matheus
 *
 */

@Entity(name = "usuarios")
public class Users implements Serializable{

	private static final long serialVersionUID = 260616964148689036L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonInclude(Include.NON_EMPTY)
	private String nome;
	
	@JsonInclude(Include.NON_EMPTY)
	@Column(name = "cpfOuCnpj" , unique = true)
	private String cpf;
	
	@JsonInclude(Include.NON_EMPTY)
	private String email;
	
	@JsonInclude(Include.NON_EMPTY)
	private String endereco;
	
	@JsonInclude(Include.NON_EMPTY)
	private String password;
	
    @OneToMany(mappedBy = "users")
	private List<Products> products;

	public Users() {
	}

	public Users(String nome, String cpf, String email, String endereco, String password, Long id, List<Products> products) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
		this.password = password;
		this.products = products;
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

	public void setCpf(String cpfOrCnpj) {
		this.cpf = cpfOrCnpj;
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
	
	public List<Products> getProducts() {
		return products;
	}
	
	public void setProducts(List<Products> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
}
