package com.bnf.aep.DTO;

import org.springframework.hateoas.RepresentationModel;

import com.bnf.aep.entities.User;

public class UserDTO extends RepresentationModel<UserDTO>{
	
	private Long id;
	
	private String nome;

	private String cpf;
	
	private String endereco;

	private String email;
	
	private String password;
	
	private String tipo;
	
	private String token;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(Long id, String nome, String cpf, String endereco, String email, String password, String tipo, String token) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
		this.password = password;
		this.tipo = tipo;
		this.token = token;
	}
		 
	 public static UserDTO toDTO(User user, String tipo) {
	        return new UserDTO(user.getId(), user.getNome(), user.getCpf(), 
	        		user.getEmail(), user.getEndereco() , user.getPassword(), tipo, user.getToken());
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
