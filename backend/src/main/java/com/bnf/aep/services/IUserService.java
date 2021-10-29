package com.bnf.aep.services;

import com.bnf.aep.DTO.UserDTO;
import com.bnf.aep.entities.User;

public interface IUserService {

	public UserDTO atualizarUsuario(final UserDTO Usuario);
	
	public UserDTO deletar(final Long cpf );
	
	public User buscaPorId(final Long cpf);
	
	public void cadastrarUsuario(final User Usuario);

}
