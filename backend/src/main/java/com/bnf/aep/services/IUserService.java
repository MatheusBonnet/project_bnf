package com.bnf.aep.services;

import com.bnf.aep.DTO.UserDTO;
import com.bnf.aep.entities.User;
import com.bnf.aep.exception.UserException;

public interface IUserService {

	
	public UserDTO deletar(final Long cpf );
	
	public User buscaPorId(final Long cpf);

	public User atualizarUsuario(UserDTO user) throws UserException;
	
	public User saveUser(UserDTO user) throws UserException;


}
