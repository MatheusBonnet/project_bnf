package com.bnf.aep.DTO;

import com.bnf.aep.entities.User;

/**
 * @author matheus
 *
 */
public class UserAuthenticationDTO {
	
	private String nome;

	private String cpf;

	private String email;
	
	private String password;
	
	private String tipo;
	
	private String token;
	
	
	
	public UserAuthenticationDTO(String cpf, String email, String password, String tipo, String token, String nome) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.password = password;
		this.tipo = tipo;
		this.token = token;
	}

	public UserAuthenticationDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public static UserAuthenticationDTO toDTO(User user, String tipo ) {
		return new UserAuthenticationDTO(user.getCpf(), user.getNome(), user.getEmail(), user.getPassword(), user.getToken(), tipo);
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
