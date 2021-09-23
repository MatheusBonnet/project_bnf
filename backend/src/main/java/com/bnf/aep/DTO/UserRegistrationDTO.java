package com.bnf.aep.DTO;

import com.bnf.aep.entities.User;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY)
public class UserRegistrationDTO {

	private String nome;
	
	private String cpf;	

	private String email;
	
	private String endereco;
	
	private String password;
	
	

    public UserRegistrationDTO() {
    }

    public UserRegistrationDTO(String nome, String cpf, String email, String endereco, String password) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
		this.password = password;
	}
    
    public User toUser() {
    	return new User(null, getNome(), getCpf(), getEmail(), getEndereco() , getPassword(), null);
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
    
}