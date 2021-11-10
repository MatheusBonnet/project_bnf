package com.bnf.aep.DTO;

import org.springframework.hateoas.RepresentationModel;

public class UserDTO extends RepresentationModel<UserDTO>{
	
	private Long id;
	
	private String nome;

	private String cpf;
	
	private String endereco;

	private String email;
	
	private String password;
	

	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDTO(String nome, String cpf, String email, String endereco, String password, Long id) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
		this.password = password;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

}
