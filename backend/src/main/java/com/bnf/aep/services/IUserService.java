package com.bnf.aep.services;

import com.bnf.aep.DTO.UserDTO;
import com.bnf.aep.entities.Users;
import com.bnf.aep.exception.UserException;

public interface IUserService {

	
	public UserDTO deletar(final Long cpf );
	
	public Users buscaPorId(final Long cpf);

	public Users atualizarUsuario(Users user) throws UserException;
	
	public Users saveUser(UserDTO user) throws UserException;


}
