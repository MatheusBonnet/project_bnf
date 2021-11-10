package com.bnf.aep.facade.populators;

import org.springframework.stereotype.Service;

import com.bnf.aep.DTO.UserDTO;
import com.bnf.aep.entities.Users;

@Service
public class UserReversePopulator implements Populator<UserDTO, Users>{

	@Override
	public void populate(UserDTO source, Users target) {
		source.setNome(target.getNome());
		source.setEmail(target.getEmail());
		source.setCpf(target.getCpf());
		source.setEndereco(target.getEndereco());
		source.setPassword(target.getPassword());
	}

}
