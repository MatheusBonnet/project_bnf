package com.bnf.aep.services;

import com.bnf.aep.entities.User;

public interface IUserService {

	public Boolean atualizarUsuario(final User Usuario);
	
	public Boolean deletar(final Long id);
	
	public User buscaPorId(final Long id);
	
	public Boolean cadastrarUsuario(final User Usuario);

}
