package com.bnf.facade.populators;

import com.bnf.aep.DTO.UserRegistrationDTO;
import com.bnf.aep.entities.User;

public class UserPopulator implements Populator<User, UserRegistrationDTO>{

	@Override
	public void populate(User source, UserRegistrationDTO target) {	
		target.setNome(source.getNome());
		target.setEmail(source.getEmail());
		target.setCpf(source.getCpf());
		target.setEndereco(source.getEndereco());
		target.setPassword(source.getPassword());
	}

}
