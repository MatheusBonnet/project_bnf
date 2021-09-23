package com.bnf.facade.populators;

import com.bnf.aep.DTO.UserRegistrationDTO;
import com.bnf.aep.entities.User;

public class UserReversePopulator implements Populator<UserRegistrationDTO, User>{

	@Override
	public void populate(UserRegistrationDTO source, User target) {
		source.setNome(target.getNome());
		source.setEmail(target.getEmail());
		source.setCpf(target.getCpf());
		source.setEndereco(target.getEndereco());
		source.setPassword(target.getPassword());
	}

}
